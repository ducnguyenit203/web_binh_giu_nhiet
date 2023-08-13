//package com.example.demo.controller;
//
//import com.example.demo.entity.Account;
//import com.example.demo.security.ParamService;
//import com.example.demo.security.UserService;
//import com.example.demo.service.impl.AccountServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class SecurityController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private ParamService paramService;
//
//    @Autowired
//    private AccountServiceImpl accountService;
//
////    @Autowired
////    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private HttpServletRequest request;
//
////    @Bean
////    public BCryptPasswordEncoder getPasswordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//    @RequestMapping("/security/login/form")
//    public String loginForm(Model model) {
//        model.addAttribute("message", "Vui lòng đăng nhập!");
//        return "security/login";
//    }
//
//    @RequestMapping("/security/login/success")
//    public String loginSuccess(Model model) {
//        model.addAttribute("message", "Đăng nhập thành công!");
//        return "security/login";
//    }
//
//    @RequestMapping("/security/login/error")
//    public String loginError(Model model) {
//        model.addAttribute("message", "Sai thông tin đăng nhập!");
//        return "security/login";
//    }
//
//    @RequestMapping("/security/logoff/success")
//    public String logoff(Model model) {
//        model.addAttribute("message", "Đăng xuất thành công!");
//        return "security/login";
//    }
//
//    @RequestMapping("/security/unauthoried")
//    public String unauthoried(Model model) {
//        model.addAttribute("message", "Bạn không có quyền truy xuất!");
//        return "security/login";
//    }
//
//    //    @RequestMapping("/oauth2/login/success")
////    public String success(OAuth2AuthenticationToken oauth2) {
////        userService.loginFormOAuth2(oauth2);
////        return "forward:/security/login/success";
////    }
//
//    @GetMapping("/register")
//    public String viewRegister(Model model) {
//        return "security/register";
//    }
//
//    @PostMapping("/register")
//    public String register(Account nd) {
//        // Đọc các tham số từ form sign up (username, email, password, repeat pass, check agree)
//        String username = paramService.getString("username", "");
//        String password = paramService.getString("password", "");
//        String email = paramService.getString("email", "");
//        String re_pass = paramService.getString("repass", "");
//        if (nd.getPassword().equals(re_pass)) {
//            nd.setFullname("NoName");
//            nd.setEmail(email);
//            nd.setPhoto("Photo.jpg");
//            nd.setPassword(password);
////            nd.setPassword(passwordEncoder.encode(password));
//            nd.setUsername(username);
//            accountService.create(nd);
//            request.setAttribute("messageS", "Đăng ký thành công bạn có thể đăng nhập ngay bây giờ!");
//
//        } else {
//            request.setAttribute("messageS", "Mật khẩu và nhập lại mật khẩu không trùng khớp!");
//        }
//
//        return "redirect:/security/login/form";
//    }
//}
