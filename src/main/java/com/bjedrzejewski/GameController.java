package com.bjedrzejewski;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by bartoszjedrzejewski on 03/08/2016.
 */
@RestController
@RequestMapping("/game")
public class GameController {
    private static final Logger log = Logger.getLogger(GameController.class);

    @RequestMapping()
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return uid.toString();
    }

}
