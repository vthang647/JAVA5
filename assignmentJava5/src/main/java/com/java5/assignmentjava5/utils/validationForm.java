package com.java5.assignmentjava5.utils;

public class validationForm {
    public boolean checkEmptyString(String text) {
        if (text.trim().isBlank()) {
            return true;
        }
        return false;
    }

    public boolean isNumberInt(String numText) {
        try {
            int number = Integer.parseInt(numText);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNumberDout(String numText) {
        try {
            double number = Double.parseDouble(numText);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
