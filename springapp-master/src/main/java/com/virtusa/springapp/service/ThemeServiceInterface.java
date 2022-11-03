package com.virtusa.springapp.service;

import java.util.List;

import com.virtusa.springapp.model.Theme;

public interface ThemeServiceInterface {
    List<Theme> getTheme();
    Theme getThemeById(Long themeId);
    Theme addTheme(Theme theme);
    String deleteTheme(Long themeId);
    String editTheme(Long themeId,Theme theme);
}
