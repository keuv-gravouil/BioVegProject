package ui.worker;

import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker.StateValue;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.swingx.JXBusyLabel;

import ui.OnlyVerticalScrollPanel;

public class ResultWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private final JLabel lblProgressMessage;
	//private final JXBusyLabel progressBar;
	private final JLabel progressBar;
	private final JTextArea txtAResult;	

	public ResultWindow(JFrame parent) {
		setLayout(new MigLayout("ins 5, hidemode 2", "[grow][right]", "[][grow]"));

		{ // Progress status
			this.lblProgressMessage = new JLabel("");
			lblProgressMessage.setBorder(new EmptyBorder(5,5,5,5));
			//lblProgressMessage.setVisible(false);
			add(lblProgressMessage, "grow");

			this.progressBar = new JLabel();
			try {
				progressBar.setIcon( new ImageIcon(ResultWindow.class.getResource("loader.gif")));
			} catch (Exception e) {
				progressBar.setText("[LOADING]");
			}
			//this.progressBar = new JXBusyLabel();
			//progressBar.setVisible(false);
			add(progressBar, "grow, wrap");
		}

		{ // Text result
			txtAResult = new JTextArea();
			txtAResult.setLineWrap(true);
			txtAResult.setFont(new Font("Monospaced",Font.PLAIN,12));
			txtAResult.setEditable(false);

			JScrollPane scroll = new JScrollPane(new OnlyVerticalScrollPanel(txtAResult));
			scroll.setBackground(Color.WHITE);
			scroll.getViewport().setBackground(Color.white);
			scroll.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(scroll, "grow, spanx 2");
		}

		setBounds(100, 100, 500, 500);
		setLocationRelativeTo(parent);
	}

	public void setProgessMessage(String text) {
		lblProgressMessage.setText(text);
	}

	public void appendResult(String line) {
		txtAResult.append(line);
	}

	public void progressDone() {
		lblProgressMessage.setVisible(false);
		progressBar.setVisible(false);
		repaint();
	}

	public void progressStart() {
		lblProgressMessage.setVisible(true);
		progressBar.setVisible(true);
		repaint();
	}

	public void run(ResultWorker worker, final String[] stepNames) {
		worker.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				//System.out.println(event);
				if(event.getPropertyName().equals("progress")) {
					if(stepNames != null) {
						final int step = (Integer) event.getNewValue();
						
						if(step<stepNames.length) {
							setProgessMessage(stepNames[step]);
						}
					}
				}
				else if(event.getPropertyName().equals("state")) {
					switch ((StateValue) event.getNewValue()) {
						case STARTED:
							setProgessMessage(stepNames[0]);
							progressStart();
							break;
						case DONE:
							progressDone();
							break;
						default: break;
					}
				}
				repaint();
			}
		});
	}
}
