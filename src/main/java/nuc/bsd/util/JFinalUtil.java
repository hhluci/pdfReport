package nuc.bsd.util;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;

public class JFinalUtil {
	private static DruidPlugin dp;
	private static ActiveRecordPlugin arp;
	public static void init() {
		 	PropKit.use("db.txt");
			 dp = new DruidPlugin(PropKit.get("mysql.jdbcUrl"),
	 				PropKit.get("mysql.user"), PropKit.get("mysql.password").trim());
	 		StatFilter statFilter = new StatFilter();
	 		dp.addFilter(statFilter);
	 		
	 		WallFilter wall = new WallFilter();
	 		wall.setDbType("mysql");
	 		dp.addFilter(wall);
	 		dp.start();
	 		 arp = new ActiveRecordPlugin(dp);
	 		 arp.start();
	}
	public static void destroy() {
		arp.stop();
		dp.stop();
	}
}
