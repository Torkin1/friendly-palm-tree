package logic;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	private List<String> args = new ArrayList<>();
	private String result;
	
	
	public List<String> getArgs() {
		return args;
	}

	public String getResult() {
		return result;
	}

	public void add() {
		this.result = this.args.get(0).concat(this.args.get(1));
	}
	
	public void sub() {
		this.result = this.args.get(0);
		if (this.args.get(0).contains(args.get(1))) {
			this.result = this.result.replace(args.get(1), "");
		}
	}
	
}
