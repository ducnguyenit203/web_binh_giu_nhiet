package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.security.ParamService;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    @Autowired
    private ParamService paramService;

    @RequestMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Product item = service.findById(id);
        List<Product> list = service.findAll();
        model.addAttribute("item", item);
        model.addAttribute("items", list);
        return "product/detail";
    }


    @RequestMapping("/product/list")
    public String list(Model model, @RequestParam("cid") Optional<Integer> cid) {
        List<Product> list;


        if (cid.isPresent()) {
            list = service.findByCategoryId(cid.get());
        } else {
            list = service.findAll();
        }
        model.addAttribute("items", list);
        return "web/menu";
    }

    @PostMapping("/product/find={name}")
    public String search(Model model, @PathVariable("name") String s) {
        String search = paramService.getString("name", "");
        List<Product> searchsp = service.findByName(s);
        model.addAttribute("searchsp", search);
        model.addAttribute("items", searchsp);
        return "web/menu";
    }

    @RequestMapping("/product/filter")
    public String filter(Model model, @RequestParam("price") Double price) {
        List<Product> list;
        list = service.findAll();
        try {
            List<Product> sr_price = null;
            if (price == 0) {
                model.addAttribute("price", price);
                sr_price = service.findByPrice(0, 600000000);
            } else if (price == 1) {
                model.addAttribute("price", price);
                sr_price = service.findByPrice(0, 30);
            } else if (price == 2) {
                model.addAttribute("price", price);
                sr_price = service.findByPrice(30, 49);
            } else if (price == 3) {
                model.addAttribute("price", price);
                sr_price = service.findByPrice(50, 69);
            } else if (price == 4) {
                model.addAttribute("price", price);
                sr_price = service.findByPrice(70, 89);
            } else if (price == 5) {
                model.addAttribute("price", price);
                sr_price = service.findByPrice(90, 10000);
            }
            model.addAttribute("items", list);
            model.addAttribute("items", sr_price);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "web/menu";
    }

}
