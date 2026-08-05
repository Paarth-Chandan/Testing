@PostMapping("/login")
public String login(@RequestParam String email,
                    @RequestParam String password,
                    HttpSession session,
                    Model model) {

    User user = userService.login(email, password);

    if(user == null) {

        model.addAttribute("error", "Invalid Email or Password");

        return "login";
    }

    session.setAttribute("loggedInUser", user);

    if(user.getRole().equalsIgnoreCase("ADMIN")) {

        return "redirect:/admin/dashboard";
    }

    return "redirect:/user/dashboard";
}

@GetMapping("/dashboard")
public String dashboard() {

    return "user/userDashboard";
}

@GetMapping("/logout")
public String logout(HttpSession session) {

    session.invalidate();

    return "redirect:/";
}
