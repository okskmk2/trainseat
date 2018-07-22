package application;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class Controller implements Initializable {

	private int eventCount;

	@FXML
	private TextArea trainlogview;
	
	@FXML
	private TextArea managementlogview;

	@FXML
	private Button seat11;
	@FXML
	private Button seat12;
	@FXML
	private Button seat13;

	@FXML
	private ComboBox<String> busCombo;

	@FXML
	private void onchange(ActionEvent event) {
		System.out.println(busCombo.getValue());
	}

	private DAO dao = new DAO();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // DB에 입력할 날짜형식
	DateFormat dfView = new SimpleDateFormat("[yyyy-MM-dd / HH:mm:ss]"); // 화면 로그뷰에 출력할 날짜형식

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("initialize");
		try {
			SerialPort serialPort = new SerialPort("COM3");
			serialPort.openPort();
			serialPort.setParams(115200, 8, 1, 0);

			serialPort.addEventListener(new SerialPortEventListener() {
				@Override
				public void serialEvent(SerialPortEvent event) {
					if (event.isRXCHAR() && event.getEventValue() > 0) {
						try {
							System.out.println("============");
							String receivedData = serialPort.readString().trim();
							System.out.println("들어온 값 : " + receivedData);
							if (eventCount == 0) {
								Date today = Calendar.getInstance().getTime();
								String reg_dt = df.format(today);
								String reg_dt_view = dfView.format(today);
								dao.insertTrainLog(reg_dt, "1호차 서버 접속 성공");
								dao.insertTrainManagementLog(reg_dt, "1351신창행 1호차 서버 접속 성공");
								trainlogview.appendText(reg_dt_view + " " + "1호차 서버 접속 성공\n");
								managementlogview.appendText(reg_dt_view + " " + "1351신창행 1호차 서버 접속 성공\n");
							}
							eventCount++;

							if (trainlogview.getText().length() > TrainSeatConst.BUS_LOGVIEW_MAXVALUE) {
								trainlogview.setText("");
							}

							String[] splitedData = receivedData.split(" ");
							if (splitedData.length == 2) {
								switch (splitedData[0]) {
								case "1-1":
									setColor(seat11, splitedData[1], splitedData[0], receivedData);
									break;

								case "1-2":
									setColor(seat12, splitedData[1], splitedData[0], receivedData);
									break;
								case "1-3":
									setColor(seat13, splitedData[1], splitedData[0], receivedData);
									break;
								default:
									System.out.println("좌석일치 없음");
									break;
								}
							} else {
								System.out.println("파싱실패");
							}
							System.out.println("============");
						} catch (SerialPortException ex) {
							System.out.println("Error in receiving string from COM-port: " + ex);
						}
					}
				}
			});
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}

	private void setColor(Button seat, String state, String seat_no, String receivedData) {
		if (TrainSeatConst.FULL.equals(state)) {
			seat.setStyle(TrainSeatConst.FULL_COLOR);
			Date today = Calendar.getInstance().getTime();
			String reg_dt = df.format(today);
			String reg_dt_view = dfView.format(today);
			dao.insertTrainLog(reg_dt, receivedData);
			dao.insertTrainManagementLog(reg_dt, "1호차 "+ receivedData);
			trainlogview.appendText("\n"+reg_dt_view + " " + receivedData);
			managementlogview.appendText("\n"+reg_dt_view + " 1호차 " + receivedData);
		} else if (TrainSeatConst.EMPTY.equals(state)) {
			seat.setStyle(TrainSeatConst.EMPTY_COLOR);
			Date today = Calendar.getInstance().getTime();
			String reg_dt = df.format(today);
			String reg_dt_view = dfView.format(today);
			dao.insertTrainLog(reg_dt, receivedData);
			dao.insertTrainManagementLog(reg_dt, "1호차 "+ receivedData);
			trainlogview.appendText("\n"+reg_dt_view + " " + receivedData);
			managementlogview.appendText("\n"+reg_dt_view + " 1호차 " + receivedData);
		} else {
			System.out.println("상태 일치없음(" + state + ")");
		}
	}

}
