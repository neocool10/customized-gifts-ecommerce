package com.virtusa.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.springapp.model.Theme;
import com.virtusa.springapp.repository.ThemeRepository;

@Service
public class ThemeServiceImpl implements ThemeServiceInterface {
    @Autowired
    private ThemeRepository themedao;

    @Override
    public List<Theme> getTheme() {
        return themedao.findAll();
    }
    
    @Override
    public Theme getThemeById(Long themeId) {
    	Optional<Theme> theme = themedao.findById(themeId);
    	if(theme.isPresent())
    		return theme.get();
    	return null;
    }
    @Override
    public Theme addTheme(Theme theme) {
        themedao.save(theme);
        return theme;
    }
    @Override
    public String deleteTheme(Long themeId) {
        themedao.deleteByThemeId(themeId);
        return "Theme Deleted Successfully!";
    }
    @Override
    public String editTheme(Long themeId,Theme theme) {
        String themeName=theme.getThemeName();
        String themeDetails=theme.getThemeDetails();
        int themePrice=theme.getThemePrice();
        themedao.editByThemeId(themeId,themeName,themeDetails,themePrice);
        return "Theme Updated Successfully!";
    }
    
}
