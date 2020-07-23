package project;

/**  
*  家庭收支系统
* @Title: FamilyPay.java  
* @Package package01    
* @author LiFupeng  
* @date 2020年6月14日  
* @company 阿里巴巴
* @version V1.0  
*/
public class FamilyPay {
	public static void main(String[] args) {
		boolean flag = true; // 定义标识,用于确定程序退出
		String datails = "收支\t 账户金额\t 收支金额\t 说明\n"; //记录用户记录收入和支出的性情
		int balace = 10000;
		while (flag) {
			System.out.println("---------------欢迎使用家庭收支系统-------------------\n");
			 System.out.println("				1.收支明细");
			 System.out.println("				2.登记收支");
			 System.out.println("				3.登记支出");
			 System.out.println("				4.退出\n");
			 System.out.print("					请选择 (1--4): ");
			 
			 // 获取用户的选择 1--4
			 char selection =  Utility.readMenuSelection();
			 switch (selection) {
				case '1':
					System.out.println("----------当前收支明细记录------------------\n");
					System.out.println(datails);
					System.out.println();
					System.out.println("-----------------------------------");
					break;
				case '2':
					System.out.print("本次收入金额: ");
					int addMoney = Utility.readNumber();
					System.out.print("本次收入说明: ");
					String addInfo = Utility.readString();
					// 处理datails变量
					balace += addMoney;
					datails += "收入\t" + balace + "\t" + addMoney + "\t" + addInfo +"\n";
					System.out.println("----------------登记完成-----------------\n");
					break;
				case '3':
					System.out.print("本次支出金额: ");
					int moneyExpend = Utility.readNumber(); // 支出金额
					System.out.print("本次支出说明: ");
					String infoExpend = Utility.readString(); // 支出说明
					if (balace >= moneyExpend) {
						balace -= moneyExpend;
						datails += "支出\t" + balace + "\t" + moneyExpend + "\t" + infoExpend +"\n";
					} else {
						System.out.println("支出超出余额,支付失败!!");
					}
					System.out.println("----------------登记完成-----------------\n");

					break;
				case '4':
					// System.out.println("退出  \n");
					System.out.print("是否确认退出 Y/N: ");
					char isExit = Utility.readConfirmSelection();
					if (isExit == 'Y') {
						flag = false;
					} 
					break;
			 }
		}
	}
}
