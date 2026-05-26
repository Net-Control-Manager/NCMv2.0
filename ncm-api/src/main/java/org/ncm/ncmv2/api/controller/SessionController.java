package org.ncm.ncmv2.api.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * SessionController serves endpoints used for managing user sessions OTHER THAN
 * Spring Security sessions.  For example, if an unauthenticated user enters a callsign
 * in the welcome modal to use NCM, SessionController would validate their callsign and
 * build their session accordingly.
 */
@Controller
@RequestMapping("/session")
public class SessionController {

    /**
     * Checks if there is currently a valid Spring Security session.
     *
     * @return ResponseEntity with 200 Code (if authenticated) or 401 Code (if unauthenticated)
     */
    @GetMapping("/check")
    public ResponseEntity<Map<String, Object>> check() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> response = new HashMap<>();

        if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
            response.put("authenticated", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("authenticated", false);
            return ResponseEntity.status(401).body(response);
        }
    }

    /**
     * Creates a new session based on user-provided callsign.  Checks to make sure it's a valid callsign, performs the
     * necessary station generation if needed, and then establishes the session.
     *
     * @param body
     * @param session
     * @return
     */
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Void> create(@RequestBody Map<String, String> body, HttpSession session) {
        System.out.println("================== METHOD HIT =====================");

        String callsign = body.get("callsign");
        session.setAttribute("callsign", callsign);
        return ResponseEntity.ok().build();
    }

}
