package com.newegg.mkpl.api.blogsystem;

import com.newegg.mkpl.api.blogsystem.util.RegularUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


/**
 * 测试类
 * @author vz04
 * @date 8/8/2019 4:45 PM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MkplApiBlogsystemApplicationTests {

	@Test
	public void contextLoads() throws IOException {
		System.out.println(RegularUtil.isUrl("156542235974.png"));
	}

}
