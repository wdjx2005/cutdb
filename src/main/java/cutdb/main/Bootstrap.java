package cutdb.main;

import cutdb.common.model.AppContext;
import cutdb.org.domain.Org;
import cutdb.org.service.OrgService;
import cutdb.user.domain.User;
import cutdb.user.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ligson on 2016/6/20.
 */
public class Bootstrap {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-conf.xml");
        OrgService orgService = (OrgService) applicationContext.getBean("orgService");
        UserService userService = (UserService) applicationContext.getBean("userService");
        /*for (int i = 0; i < 2; i++) {
            AppContext.currentTenantId = "org" + (i + 1);
            Org org = orgService.addOrg("org" + (i + 1));
            User user = userService.register("user1", "password", true, org);
            System.out.println(user);
        }*/
        AppContext.currentTenantId = "org1";
        System.out.println(userService.list(new String[]{"id","name"}).get(0));

    }
}
