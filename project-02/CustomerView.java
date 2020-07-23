package project;

/**  
* 用户数据展示和处理用户的操作
* @Title: Bank.java  
* @Package project    
* @author LiFupeng  
* @date 2020年6月19日  
* @company 阿里巴巴
* @version V1.0  
*/
public class CustomerView {
	
	private CustomerList custList = new CustomerList(10);
	
	
	
	
	public CustomerView() {
		Customer customer = new Customer("雷军",'男',45,"18212241332","125511@qq.com");
		custList.addCustomer(customer);
	}


	/**
	 * 显示客户信息管理软件界面的方法
	 */
	public void findCustomerMenu() {
		boolean flag = true;
		do {
			System.out.println("****************客户信息管理软件*****************");
			System.out.println("                1.添加客户");
			System.out.println("                2.修改客户");
			System.out.println("                3.删除客户");
			System.out.println("                4.客户列表");
			System.out.println("                5.退 出\n");
			System.out.print("             请选择1--5:");
			
			char menu = CMUtility.readMenuSelection();
			switch (menu) {
			case '1':
				addCustomer();
				break;
			case '2':
				updateCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				getCustomerList();
				break;
			case '5':
				System.out.print("是否确认退出(Y/N): ");
				char isExit = CMUtility.readConfirmSelection();
				if (isExit == 'Y') {
					flag = false;
				}
				

			}
		} while (flag);
	}
	
	
	/**
	 * 添加用户执行方方法
	 */
	public void addCustomer() {
		System.out.println("***************添加用户*******************");
		System.out.print("姓名: ");
		String name = CMUtility.readString(10);
		System.out.print("性别: ");
		char sex = CMUtility.readChar();
		System.out.print("年龄: ");
		int age = CMUtility.readInt();
		System.out.print("电话: ");
		String phone = CMUtility.readString(11);
		System.out.print("邮箱: ");
		String email = CMUtility.readString(10);
		//将以上数据封装子在对象中
		Customer customer = new Customer(name,sex,age,phone,email);
		boolean isSuccess = custList.addCustomer(customer);
		if (isSuccess) {
			System.out.println("添加完成");
		} else {
			System.out.println("客户已满,添加失败");
		}
		
	}
	
	/**
	 * 修改客户的执行方法
	 */
	public void updateCustomer() {
		System.out.println("******************修改客户********************");
		Customer cuts;
		int num;
		for(;;) {
			System.out.print("请选择要修改客户的编号   (-1退出):");
			num = CMUtility.readInt();
			if (num == -1) {
				return;
			}
			cuts = custList.getCustomerIndex(num-1);//客户的索引从0开始
			if (cuts == null) {
				System.out.println("找不到指定客户");
			} else {
				break;
			}
		}
		//执行修改客户方法
		System.out.print("姓名(" +cuts.getName() +"): ");
		String name = CMUtility.readString(10,cuts.getName());
		
		System.out.print("性别(" +cuts.getSex() +"): ");
		char sex = CMUtility.readChar(cuts.getSex());
		
		System.out.print("年龄(" +cuts.getAge() +"): ");
		int age = CMUtility.readInt(cuts.getAge());
		
		System.out.print("电话(" +cuts.getPhone() +"): ");
		String phone = CMUtility.readString(11,cuts.getPhone());
		
		System.out.print("邮箱(" +cuts.getEmail()+"): ");
		String email = CMUtility.readString(20,cuts.getEmail());
		//将以上数据封装在对象中
		Customer newCustomer = new Customer(name,sex,age,phone,email);
		boolean isUpdate = custList.updateCustomerIndex(num-1, newCustomer);
		if (isUpdate) {
			System.out.println("修改完成");
		} else {
			System.out.println("修改失败");
		}
		
	}
	
	/**
	 *  删除制定索引位置上的客户
	 */
	public void deleteCustomer() {
		System.out.println("*************删除制定索引位置上的客户************");
		int num ;
		for(; ;) {
			System.out.println("请选择要删除客户的编号   (-1退出): ");
			num = CMUtility.readInt();
			if (num == -1) {
				return;
			}
			Customer customer = custList.getCustomerIndex(num-1);
			if(customer == null) {
				System.out.println("找不到客户");
			} else {
				break;
			}
		}
		//执行删除
		System.out.println("是否确认删除 Y/N:");
		char isDelete = CMUtility.readConfirmSelection();
		if (isDelete == 'Y') {
			boolean deleteCustomerSuccess = custList.deleteCustomer(num - 1);
			if(deleteCustomerSuccess) {
				System.out.println("删除成功");
			}
			
		} else {
			return;
		}
	}
	
	/**
	 * 获取所有用户信息
	 */
	public void getCustomerList() {
		System.out.println("***************客户列表**********************\n");
		int total = custList.getTotal();
		if (total == 0) {
			System.out.println("没有客户信息");
		} else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			Customer[] customersAll = custList.getCustomersAll();
			for (int i = 0; i < customersAll.length; i++) {
				Customer cuts = customersAll[i];
				System.out.println((i+1) +"\t"+ cuts.getName() +"\t"+ cuts.getSex() +"\t"
									+cuts.getAge() +"\t"+ cuts.getPhone() +"\t"+cuts.getEmail());
			}
		}
		System.out.println("***************客户列表完成*****************\n");
	}

	
	
	
	
	public static void main(String[] args) {
		CustomerView customerView = new CustomerView();
		customerView.findCustomerMenu();
	}

}
