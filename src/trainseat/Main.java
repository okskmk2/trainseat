package main;

import jssc.SerialPortException;

public class Main {
	public static void main(String[] args) {
		
		TrainServer frame = new TrainServer();

		try {
			frame.setVisible(true);
			new SerialTest(frame);
		} catch (SerialPortException ex) {
			System.out.println(ex);
		}
	}
}