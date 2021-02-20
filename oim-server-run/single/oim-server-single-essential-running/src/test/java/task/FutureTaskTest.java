package task;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FutureTaskTest {

	@RequestMapping("/task/test1")
	public HashMap<String, Object> getService1() throws InterruptedException, ExecutionException {

		System.out.println("线程名称:" + Thread.currentThread().getName());
		long start = System.currentTimeMillis();
		HashMap map = new HashMap<>();

		Callable<Object> callable1 = new Callable<Object>() {
			// 调用接口返回json
			@Override
			public Object call() throws Exception {
				// JSONObject json = JSONObject.parseObject(testA());
				System.out.println("子线程1："+Thread.currentThread().getName());
				return testA();
				// return json;
			}
		};

		Callable<Object> callable2 = new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				// JSONObject json =JSONObject.parseObject(testB());
				// return json;
				System.out.println("子线程2："+Thread.currentThread().getName());
				return testB();
			}
		};

		FutureTask<Object> oneTask = new FutureTask<Object>(callable1);
		FutureTask<Object> twoTask = new FutureTask<Object>(callable2);
		// 多线程运行
		new Thread(oneTask).start();
		new Thread(twoTask).start();
		// 计算
		map.put("A", oneTask.get());
		map.put("B", twoTask.get());
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start));
		System.out.println("主线程名称:" + Thread.currentThread().getName()+"结束！");
		return map;
	}

	@RequestMapping("/task/test2")
	public HashMap getService2() throws InterruptedException, ExecutionException {
		HashMap map = new HashMap<>();
		long start = System.currentTimeMillis();
		String a = testA();
		String b = testB();

		// 计算
		map.put("A", a);
		map.put("B", b);
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start));
		return map;
	}

	public String testA() throws InterruptedException {

		Thread.sleep(1000);
		System.out.println("执行A");
		return "A";
	}

	public String testB() throws InterruptedException {
		Thread.sleep(1500);
		System.out.println("执行B");
		return "B";

	}
}
