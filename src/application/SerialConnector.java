package application;

import javafx.scene.control.TextArea;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class SerialConnector {
	public SerialConnector(TextArea textArea) throws SerialPortException {
		SerialPort serialPort = new SerialPort("COM3");
		serialPort.openPort();
		serialPort.setParams(115200, 8, 1, 0);
		serialPort.addEventListener(new SerialPortEventListener() {
			@Override
			public void serialEvent(SerialPortEvent event) {
				if (event.isRXCHAR() && event.getEventValue() > 0) {
					try {
						String receivedData = serialPort.readString(event.getEventValue());
						textArea.appendText(receivedData);
						System.out.println(receivedData);
					} catch (SerialPortException ex) {
						System.out.println("Error in receiving string from COM-port: " + ex);
					}
				}
			}
		});
	}
}
