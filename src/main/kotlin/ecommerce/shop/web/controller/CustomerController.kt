package ecommerce.shop.web.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class CustomerController {

    @GetMapping
    fun index() : String = "/index"

    @GetMapping("/customer/signup")
    fun adminUserForm(model: Model): String {
        return "/customer/signup"
    }


    @GetMapping("/customer/login")
    fun loginForm(@RequestParam(value = "error", defaultValue = "false") error: Boolean, model: Model): String? {
        if (error) {
            model.addAttribute("loginFailure", true)
            model.addAttribute("loginFailureMessage", "아이디와 패스워드를 확인하시고 다시 로그인해주세요.")
        }
        return "/customer/login"
    }

}