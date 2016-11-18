package ro.bydl.service;

public class StringHelper {

	public String formatFirstToUpeerOtherToLowerCase(String nameToDo) {
		String name = "";
		if(nameToDo!=null){
		

		String[] first = nameToDo.split("");

		int count = 0;
		for (String s : first) {
			if (count == 0) {
				name = s.toUpperCase();
			} else {
				name += s.toLowerCase();
			}
			count++;
		}
		}else{
			name="";
		}
		return name;

	}
	
	public boolean containsSimbols(String string){
		String[] chars = string.split("");
		String done = "";
		for (String s : chars) {
			if (s.matches("[a-zA-z]{1}")) {
				done += s;
			} else if (s.matches("\\d{1}")) {
				done += s;
			}

		}
		done = done.replaceAll(" ", "");
		done = done.toLowerCase();
		if(string.length()!=done.length()){
			return true;
		}
		return false;
	}
	
}