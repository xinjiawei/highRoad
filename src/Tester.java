import httplib.*;
import washdata.*;
import store.*;

public class Tester {
	public static void main(String[] args) {
		HTTPRequest request = new HTTPRequest();
		
		String responceData = request.get("https://test.jiawei.xin/road/oper/getjson.php");
		
		Wash a = new Wash(responceData);
		String b = a.toStringOfAllInforation();
		//一次清洗，去掉NULL值和n.a.的值，替换为NO Record
		Wash c = new Wash(b);
		String d = c.sortOfAll();
		//清洗json格式

		Store e = new Store(d);
		String f = e.JsonAray();
		//将数据存入数组，然后入库

		System.out.println(f);	
	}
}