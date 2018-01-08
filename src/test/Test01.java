/**
* @author 黄为涛
* @time 2018年1月8日 上午10:00:37
* @projectName OSTest
*
**/
package test;

import org.junit.Test;

import utils.Myutil;

public class Test01 {

	@Test
	public void Test01() {
		Myutil.addSrring2File("D://data.txt", "111");
	}
}
