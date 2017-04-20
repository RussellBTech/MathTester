package cs113.miracosta.edu;

import java.awt.EventQueue;

import gui.GUI;

public class FinalProjectSubmission {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmMathDiagnosticsJutech.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
