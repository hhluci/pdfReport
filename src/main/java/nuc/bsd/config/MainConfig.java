package nuc.bsd.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.template.Engine;

import nuc.bsd.util.DebugInfo;

public class MainConfig extends JFinalConfig {
    public void configConstant(Constants me) {
        PropKit.use("db.txt");
		me.setEncoding("UTF-8");
		// �����Ƿ��ǿ���ģʽ������ģʽ
		me.setDevMode(PropKit.getBoolean("devMode", true));
	
		// ����404����ҳ��
		me.setError404View(Constant.error404PagePath);
		// ����500����ҳ��
		me.setError500View(Constant.error500PagePath);
		// ����Ĭ�ϵ��ļ��ϴ���·��
		me.setBaseUploadPath(Constant.uploadSaveDir);
		// ����Ĭ�ϵ����ص��ļ�·��
		me.setBaseDownloadPath(Constant.downloadSaveDir);
		// ����URL�м�ķָ�����Ĭ���ҡ�-����
		me.setUrlParaSeparator(Constant.URLPARASEPARATOR);
		// ��������ϴ��ߴ�
		me.setMaxPostSize(Constant.MAXPOSTSIZE);
     }
     public void configRoute(Routes me) {
    	
     }
     public void configEngine(Engine me) {}

     /**
 	 * ����C3P0����Դ
 	 * 
 	 * @return
 	 */
 	public static C3p0Plugin createC3p0Plugin() {

 		return new C3p0Plugin(PropKit.get("mysql.jdbcUrl"),
 				PropKit.get("mysql.user"), PropKit.get("mysql.password").trim());
 	}

 	@Override
 	public void configPlugin(Plugins me) {
 		// TODO Auto-generated method stub
 		DebugInfo.log("MainConfig", "��ʼ�����ò��...");
 		DebugInfo.log("MainConfig", "��ʼ����������Դ...");
 		DruidPlugin dp = new DruidPlugin(PropKit.get("mysql.jdbcUrl"),
 				PropKit.get("mysql.user"), PropKit.get("mysql.password").trim());
 		StatFilter statFilter = new StatFilter();
 		dp.addFilter(statFilter);
 		WallFilter wall = new WallFilter();
 		wall.setDbType("mysql");
 		dp.addFilter(wall);
 		me.add(dp);
 		DebugInfo.log("MainConfig", "��ʼ����������Դ���ݱ�ʵ���...");
 		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
 		me.add(arp);
 		// ���������� MappingKit �и㶨
 		_MappingKit.mapping(arp);
 	}

 	@Override
 	public void configInterceptor(Interceptors me) {
 		// TODO Auto-generated method stub
 		
 	}

 	@Override
 	public void configHandler(Handlers me) {
 		// TODO Auto-generated method stub
 		me.add(new ContextPathHandler("ctx"));
 		DruidStatViewHandler dvh = new DruidStatViewHandler("/druid");
 		me.add(dvh); 

 	}
 	
 	
     public static void main(String[] args) {
    		/*JFinal.start("WebContent", 9000, "/", 5);*/
    	 JFinal.start("WebContent", 7000, "/");
    	
    	}
}
