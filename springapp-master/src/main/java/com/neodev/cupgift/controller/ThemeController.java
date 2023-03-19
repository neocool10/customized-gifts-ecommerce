package com.neodev.cupgift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neodev.cupgift.model.Theme;
import com.neodev.cupgift.service.ThemeServiceInterface;
import com.neodev.cupgift.tempmodel.TempTheme;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class ThemeController {
    
    @Autowired
    private ThemeServiceInterface themeService;

   
   @GetMapping("/admin/getTheme")
   public List<Theme> getAdminTheme(){
    return this.themeService.getTheme();
   }
   
   @GetMapping("/user/getTheme")
   public List<Theme> getUserTheme(){
    return this.themeService.getTheme();
   }
   
   @GetMapping("/user/getThemeById/{themeId}")
   public Theme getThemeById(@PathVariable(value="themeId") Long themeId) {
	   return this.themeService.getThemeById(themeId);
   }
   
   @PostMapping("/admin/addTheme")
   public Theme addTheme(@RequestBody TempTheme theme){
	   Theme t = new Theme();
	   t.setThemeId(theme.getThemeId());
	   t.setThemeName(theme.getThemeName());
	   t.setThemePrice(theme.getThemePrice());
	   t.setThemeDetails(theme.getThemeDetails());
       return this.themeService.addTheme(t);
   }
   @DeleteMapping("/admin/deleteTheme/{themeId}")
   public String deleteTheme(@PathVariable(value="themeId") Long themeId){
       return this.themeService.deleteTheme(themeId);
   }
   @PutMapping("/admin/editTheme/{themeId}")
   public String editTheme(@PathVariable(value="themeId") Long themeId,@RequestBody TempTheme theme){
	   Theme t = new Theme();
	   t.setThemeId(themeId);
	   t.setThemeName(theme.getThemeName());
	   t.setThemePrice(theme.getThemePrice());
	   t.setThemeDetails(theme.getThemeDetails());
       return this.themeService.editTheme(themeId,t);
   }

}
