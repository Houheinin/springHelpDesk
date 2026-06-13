package com.example.helpdesk.controller;
import java.util.Map;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Help Desk");
        model.addAttribute("welcomeMessage", "Добро пожаловать в Help Desk");
        model.addAttribute("features", List.of(
                "Регистрация обращений",
                "Приоритизация задач",
                "Контакты поддержки",
                "База Данных"
        ));
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "О нас");
        model.addAttribute("teamName", "Учебная команда Help Desk");
        model.addAttribute("description",
                "Мы создаём учебную систему для обработки обращений пользователей.");
        return "about";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("pageTitle", "Контакты поддержки");
        model.addAttribute("supportEmail", "support@helpdesk.local");
        model.addAttribute("workTime", "Пн-Пт, 09:00-18:00");
        model.addAttribute("phone", "+7 (000) 000-00-00");

        List<String> obrashenie = List.of(
                "Фио и контактные данные",
                "Проблемка",
                "скрины"
        );
        model.addAttribute("obrashenie", obrashenie);

        List<Map<String, String>> SupportCh = List.of(
                Map.of("channel", "Email", "value", "supporthelpdesk@gmail.ululu"),
                Map.of("channel", "Телефон", "value", "8 800 555 35 35"),
                Map.of("channel", "Telegram", "value", "@helpdesk_support")
        );
        model.addAttribute("SupportCh", SupportCh);

        return "contacts";
    }

    @GetMapping("/faq")
    public String faq(Model model) {
        model.addAttribute("pageTitle", "Частые вопросы:");
        List<Map<String, String>> faqList = List.of(
                Map.of("question", "Как написать обращение?",
                        "answer", "Свяжитесь с поддержкой"),
                Map.of("question", "Через сколько приходит ответ?",
                        "answer", "В течение дня."),
                Map.of("question", "Как узнать статус обращения?",
                        "answer", "в теории в личном кабинете если будет хз"),
                Map.of("question", "Можно ли запросить консультацию по телефону?",
                        "answer", "Да, наш сотрудник перезвонит")
        );
        model.addAttribute("faqList", faqList);
        return "faq";
    }
}
