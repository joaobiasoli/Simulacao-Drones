package aplicacao;

import dados.Tela;

import javax.swing.*;

public class ACMEAirDrones {
	public void executar() {

		SwingUtilities.invokeLater(() -> {
			Tela frame = new Tela();
			frame.setVisible(true);
		});
	}
}
