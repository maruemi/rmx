package plugins.acc;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import logic.interfaces.PluginInterface;
import plugins.acc.list.ListAcc;
import plugins.acc.regist.RegistAcc;
import data.Message;

public class AccPlugin implements PluginInterface{

	@Override
	public List<Message> pluginStart(
			Message oMsg,
			String function,
			String command,
			List<String> commandArgs,
			List<String> recipients,
			ResourceBundle domBundle,
			String propfile) {
		
		ArrayList<Message> sMsgs = new ArrayList<Message>();
		if(command.equalsIgnoreCase("regist")) {
			RegistAcc r_acc = new RegistAcc(commandArgs, oMsg, domBundle, recipients);
			r_acc.saveAddress();
			sMsgs.add(r_acc.createReply());
			System.out.println("test");
		}
		
		//
		else if(command.equalsIgnoreCase("list")) {
			ListAcc l_acc = new ListAcc(commandArgs, oMsg, domBundle, recipients);
			sMsgs.add(l_acc.createReply());
		}
		
		return null;
	}

	@Override
	public ArrayList<String> getAvailableFunctionNames() {
		ArrayList<String> al = new ArrayList<String>();
		String function_name = "acc";
		al.add(function_name);
		return al;
	}

}
