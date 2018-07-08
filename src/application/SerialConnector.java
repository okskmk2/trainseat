package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class SerialConnector {
	
	private String full = "가능";
	private String empty = "불가능";
	private int buslogviewMaxValue = 2000; // 로그창에 지나치게 많은 텍스트가 있으면 스크롤이 내려가지 않는다.
	private DAO dao = new DAO();
	DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public SerialConnector(TextArea textArea, Button seat11, Button seat12, Button seat13) throws SerialPortException {
		SerialPort serialPort = new SerialPort("COM3");
		serialPort.openPort();
		serialPort.setParams(115200, 8, 1, 0);
		serialPort.addEventListener(new SerialPortEventListener() {
			@Override
			public void serialEvent(SerialPortEvent event) {
				if (event.isRXCHAR() && event.getEventValue() > 0) {
					try {
						System.out.println("============");
						String receivedData = serialPort.readString(event.getEventValue());
						System.out.println("들어온 값 : " + receivedData);
						if (textArea.getText().length() > buslogviewMaxValue) {
							textArea.setText("");
						}
						textArea.appendText(receivedData);
						String[] splitedData = receivedData.trim().split(" ");
						if (splitedData.length == 2) {
							switch (splitedData[0]) {
							case "1-1":
								setColor(seat11, splitedData[1]);
								break;

							case "1-2":
								setColor(seat12, splitedData[1]);
								break;
							case "1-3":
								setColor(seat13, splitedData[1]);
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
	}

	private void setColor(Button seat, String state) {
			if (full.equals(state)) {
				seat.setStyle("-fx-background-color: #3dee0d;");
				Date today = Calendar.getInstance().getTime();        
				String reg_dt = df.format(today);
				dao.insertTrainLog(1, 1, 1, 1, reg_dt); // TODO
			} else if(empty.equals(state)) {
				seat.setStyle("-fx-background-color: #ea2b2b;");
			} else {
				System.out.println("상태 일치없음(" + state + ")");
			}
	}
}
