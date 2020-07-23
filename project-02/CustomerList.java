package project;

/**  
* 客户管理类
* @Title: CustomerList.java  
* @Package project    
* @author LiFupeng  
* @date 2020年6月19日  
* @company 阿里巴巴
* @version V1.0  
*/
public class CustomerList {

	private Customer[] customers; //存储用户的对象数组
	private int total = 0; //记录已有用户的数量
	
	public CustomerList() {
		super();
	}
	public CustomerList(int totalCustomer) {
		customers = new Customer[10]; //初始化对象数组
	}
	
	public CustomerList(Customer[] customers, int total) {
		super();
		this.customers = customers;
		this.total = total;
	}
	
	/**
	  *   添加客户
	 * @param customer
	 * @return true添加成功,false失败
	 */
	public boolean addCustomer(Customer customer) {
		//对象数组存储已满,添加失败
		if (total >= customers.length) {
			return false;
		}
		customers[total++] = customer;
		return true;
	}
	
	/**
	  * 修改指定索引位置的客户信息
	 * @param index
	 * @param cus
	 * @return true成功  false失败
	 */
	public boolean updateCustomerIndex(int index,Customer cus) {
		//对象数组下标小于0或者大于等于客户数量,返回修改失败
		if (index < 0 || index <= total) {  //坑:index <= total 修改失败
			return false; 
		}
		customers[index] = cus; //成功将修改的客户信息赋值给要修改数组中索引所在位置的客户
		return true;
	}
	
	/**
	  * 删除制定索引位置上的客户
	 * @param index
	 * @return 同上
	 */
	public boolean deleteCustomer(int index) {
		if (index < 0 || index >= total) {
			return false;
		}
		for (int i = index; i < total-1; i++) {
			customers[i] = customers[i+1];
		}
		//将要删除元素置空
		customers[--total] = null;
		return true;
	}
	
	/**
	  * 获取所有用户信息
	 * @return
	 */
	public Customer[] getCustomersAll() {
		Customer[] cust = new Customer[total];
		for (int i = 0; i < total; i++) {
			cust[i] = customers[i];
		}
		return cust;
	}
	
	/**
	 * 获取指定索引位置上的客户
	 * @param index
	 * @return
	 */
	public Customer getCustomerIndex(int index) {
		////对象数组下标小于0或者大于等于客户数量,找不到
		if (index < 0 || index >= total) {
			return null;
		}
		return customers[index];
	}
	
	/**
	  * 获取所有客户
	 * @return
	 */
	public int getTotal() {
		return total;
	}
}
