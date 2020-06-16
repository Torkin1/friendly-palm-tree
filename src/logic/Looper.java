package logic;

import java.util.logging.Level;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.*;

public class Looper {
	private boolean exit = false;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private BufferedReader consoleReader;
	private Controller controller = new Controller();
	
	public Looper() {
		this.consoleReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void loop() {
		this.logger.log(Level.INFO, "entering loop");
		String input;
		String first;
		String second;

		while (!this.exit) {
			try {
				logger.log(Level.INFO, "Choose an op: (a)dd, (s)ub");
				input = this.consoleReader.readLine();
				logger.log(Level.INFO, "enter first string: ");
				first = this.consoleReader.readLine();
				logger.log(Level.INFO, first);
				logger.log(Level.INFO, "enter s string: ");
				second = this.consoleReader.readLine();
				logger.log(Level.INFO, first);
				this.controller.getArgs().add(0, first);
				this.controller.getArgs().add(1, second);
				String resultMessage = "result is: ";
				if (input == "a") {
					this.controller.add();
				}
					
				else if (input == "s") {
					this.controller.sub();
					}
				else {
					logger.log(Level.INFO, "error");
				}
				
				resultMessage += this.controller.getResult();
				logger.log(Level.INFO, resultMessage );
			} catch (IOException e) {
				logger.log(Level.INFO,  e.toString());
			}
		}
	}
}
