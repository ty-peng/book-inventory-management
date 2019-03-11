package 工具类util;
/*
 * 字符串工具类
 */
public class StringUtil {
	//判断字符串为空
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim())){
			return true;
		}
		else {
			return false;
		}
	}
	
	//判断字符串不为空
		public static boolean isNotEmpty(String str){
			if(str!=null&&!"".equals(str.trim())){
				return true;
			}
			else {
				return false;
			}
		}
	
	//判断字符串是不是实数
		public static boolean isNum(String ss){  
			for(int i=0;i<ss.length();i++)
			{
				char a=ss.charAt(i);
				if((a>='0'&&a<='9')||a=='.')
				{
					return true;
				}
			}
			return false;
		}
	
	
	
	
}
