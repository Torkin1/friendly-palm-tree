package logic;

import java.util.logging.Level;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.*;;

public class Looper {
	private boolean exit = false;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private BufferedReader consoleReader;
	private String first;
	private String second;
	private Controller controller = new Controller();
	
	public Looper() {
		this.consoleReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void loop() {
		this.logger.log(Level.INFO, "entering loop");
		String input;
		while (!this.exit) {
			try {
				logger.log(Level.INFO, "Choose an op: (a)dd, (s)ub");
				input = this.consoleReader.readLine();
				logger.log(Level.INFO, "enter first string: ");
				this.first = this.consoleReader.readLine();
				logger.log(Level.INFO, this.first);
				logger.log(Level.INFO, "enter s string: ");
				this.second = this.consoleReader.readLine();
				logger.log(Level.INFO, this.first);
				this.controller.getArgs().add(0, this.first);
				this.controller.getArgs().add(1, this.second);
				String resultMessage = "result is: ";
				switch (input) {
				case "a":
					this.controller.add();
					break;
				case "s":
					this.controller.sub();
					break;
				}
				logger.log(Level.INFO, resultMessage += this.controller.getResult());
			} catch (IOException e) {
				logger.log(Level.INFO,  e.toString());
			}
		}
	}
}
