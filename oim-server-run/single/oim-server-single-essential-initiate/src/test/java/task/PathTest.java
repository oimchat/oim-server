
package task;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

/**
 * Description <br>
 * Date 2020-04-20 16:58:26<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class PathTest {

	public static void main(String[] args) {
		int parts = 2;
		String path = "/mam/uris/id";
		String newPath = "/"
				+ Arrays.stream(StringUtils.tokenizeToStringArray(path, "/"))
						.skip(parts).collect(Collectors.joining("/"));
		newPath += (newPath.length() > 1 && path.endsWith("/") ? "/" : "");

		System.out.println(newPath);

	}

}
