package com.demo01.test01.controller;

import com.demo01.test01.model.HelloData;
import com.demo01.test01.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {
    private static Logger log = LoggerFactory.getLogger(HelloController.class);
    private HelloService helloService;
    @Autowired
    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    //传参方式1
    //本方法将处理/hello/helloView?helloId=10
    @RequestMapping(value = "/helloView", method = RequestMethod.GET)
    public String viewHello(@RequestParam("helloId") Integer helloId, Model model){
        log.debug("helloId = " + helloId);
        HelloData data = helloService.getHelloData(helloId);
        model.addAttribute(data);
        return "indexHello";
    }
    //传参方式2
    //本方法将处理/hello/helloView2/{helloId}
    @RequestMapping(value = "/helloView2/{helloId}", method = RequestMethod.GET)
    public String viewHello2(@PathVariable("helloId") Integer helloId, Map<String,Object> model){
        log.debug("helloId = " + helloId);
        HelloData data = helloService.getHelloData(helloId);
        model.put("data", data);
        return "indexHello";
    }

    //传参方式3 传统servlet传参
    //本方法将处理/hello/helloView3?helloId=10
    @RequestMapping(value = "/helloView3", method = RequestMethod.GET)
    public String viewHello3(HttpServletRequest request){
        Integer helloId = Integer.valueOf(request.getParameter("helloId"));
        log.debug("helloId = " + helloId);
        HelloData data = helloService.getHelloData(helloId);
        request.setAttribute("data", data);
        return "indexHello";
    }

    //joson格式第1种    本方法将处理/hello/10
    @RequestMapping(value = "/{helloId}", method = RequestMethod.GET)
    public @ResponseBody HelloData getHelloInJson(@PathVariable Integer helloId){
        return helloService.getHelloData(helloId);
    }
    //joson格式第2种    本方法将处理/hello/jsontype/10
    @RequestMapping(value = "/jsontype/{helloId}", method = RequestMethod.GET)
    public ResponseEntity<HelloData> getHelloInJson2(@PathVariable Integer helloId){
        HelloData data = helloService.getHelloData(helloId);
        return new ResponseEntity<HelloData>(data, HttpStatus.OK);
    }

    //添加Hello方法 本方法将处理/hello/amin?add
    @RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
    public String addHello(){
        return "addHello";
    }

    //保存Hello方法表单提交
    @RequestMapping(value = "/admin/saveHello", method = RequestMethod.POST)
    public String saveHello(HelloData helloData){
        log.debug("表单返回数据:" + helloData.getHelloId()+" " + helloData.getListHello());
        System.out.println("保存到数据库罗辑");
        return "redirect:/hello/helloView2/" + helloData.getHelloId();
    }

    //文件上传方法
    @RequestMapping(value = "/addFile", method = RequestMethod.GET)
    public String addUplodFile(){
        return "addFile";
    }

    //文件保存
    @RequestMapping(value = "/saveFile", method = RequestMethod.POST)
    public String saveUplodFile(HttpServletRequest request, @RequestParam("upFile") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            String filePath = request.getSession().getServletContext()
                    .getRealPath("/") + "resources/upload/" + System.currentTimeMillis() + file.getOriginalFilename();
            log.debug("日志输出表单传来的文件:" + file.getOriginalFilename());
            File saveDir = new File(filePath);
            // 转存文件
            file.transferTo(saveDir);
        }
        return "success";
    }

}
