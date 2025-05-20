package net.nic.npc.kingdom;

public class ColorStorage {

    // Grayscale
    public static int black = 0x000000;
    public static int white = 0xFFFFFF;
    public static int gray10 = 0x1A1A1A;
    public static int gray20 = 0x333333;
    public static int gray30 = 0x4D4D4D;
    public static int gray40 = 0x666666;
    public static int gray50 = 0x808080;
    public static int gray60 = 0x999999;
    public static int gray70 = 0xB3B3B3;
    public static int gray80 = 0xCCCCCC;
    public static int gray90 = 0xE6E6E6;

    // Red shades
    public static int red = 0xFF0000;
    public static int darkRed = 0x8B0000;
    public static int lightCoral = 0xF08080;
    public static int indianRed = 0xCD5C5C;
    public static int firebrick = 0xB22222;
    public static int crimson = 0xDC143C;
    public static int tomato = 0xFF6347;
    public static int salmon = 0xFA8072;
    public static int lightSalmon = 0xFFA07A;
    public static int darkSalmon = 0xE9967A;

    // Orange shades
    public static int orange = 0xFFA500;
    public static int darkOrange = 0xFF8C00;
    public static int coral = 0xFF7F50;
    public static int tomatoRed = 0xFF6347;

    // Yellow shades
    public static int yellow = 0xFFFF00;
    public static int lightYellow = 0xFFFFE0;
    public static int lemonChiffon = 0xFFFACD;
    public static int lightGoldenrod = 0xFAFAD2;
    public static int papayaWhip = 0xFFEFD5;
    public static int moccasin = 0xFFE4B5;

    // Green shades
    public static int green = 0x00FF00;
    public static int darkGreen = 0x006400;
    public static int forestGreen = 0x228B22;
    public static int limeGreen = 0x32CD32;
    public static int lightGreen = 0x90EE90;
    public static int paleGreen = 0x98FB98;
    public static int springGreen = 0x00FF7F;
    public static int mediumSpringGreen = 0x00FA9A;

    // Blue shades
    public static int blue = 0x0000FF;
    public static int mediumBlue = 0x0000CD;
    public static int darkBlue = 0x00008B;
    public static int navy = 0x000080;
    public static int royalBlue = 0x4169E1;
    public static int dodgerBlue = 0x1E90FF;
    public static int deepSkyBlue = 0x00BFFF;
    public static int skyBlue = 0x87CEEB;
    public static int lightSkyBlue = 0x87CEFA;
    public static int powderBlue = 0xB0E0E6;

    // Purple shades
    public static int purple = 0x800080;
    public static int indigo = 0x4B0082;
    public static int violet = 0xEE82EE;
    public static int orchid = 0xDA70D6;
    public static int plum = 0xDDA0DD;
    public static int thistle = 0xD8BFD8;
    public static int lavender = 0xE6E6FA;

    // Pink shades
    public static int pink = 0xFFC0CB;
    public static int lightPink = 0xFFB6C1;
    public static int hotPink = 0xFF69B4;
    public static int deepPink = 0xFF1493;
    public static int paleVioletRed = 0xDB7093;
    public static int mediumVioletRed = 0xC71585;

    // Brown shades
    public static int brown = 0xA52A2A;
    public static int maroon = 0x800000;
    public static int sienna = 0xA0522D;
    public static int saddleBrown = 0x8B4513;
    public static int chocolate = 0xD2691E;
    public static int peru = 0xCD853F;
    public static int sandyBrown = 0xF4A460;
    public static int burlyWood = 0xDEB887;
    public static int tan = 0xD2B48C;
    public static int wheat = 0xF5DEB3;

    // Aqua / Cyan shades
    public static int aqua = 0x00FFFF;
    public static int cyan = 0x00FFFF;
    public static int lightCyan = 0xE0FFFF;
    public static int paleTurquoise = 0xAFEEEE;
    public static int aquamarine = 0x7FFFD4;
    public static int turquoise = 0x40E0D0;
    public static int mediumTurquoise = 0x48D1CC;
    public static int darkTurquoise = 0x00CED1;

    // Special colors
    public static int gold = 0xFFD700;
    public static int silver = 0xC0C0C0;
    public static int bronze = 0xCD7F32;

    // Random mixed shades
    public static int mintCream = 0xF5FFFA;
    public static int honeydew = 0xF0FFF0;
    public static int ivory = 0xFFFFF0;
    public static int beige = 0xF5F5DC;
    public static int seashell = 0xFFF5EE;
    public static int snow = 0xFFFAFA;
    public static int linen = 0xFAF0E6;
    public static int oldLace = 0xFDF5E6;
    public static int floralWhite = 0xFFFAF0;
    public static int ghostWhite = 0xF8F8FF;
    public static int aliceBlue = 0xF0F8FF;
    public static int lavenderBlush = 0xFFF0F5;

    public static int getColorCycleButton(int value) {
        int[] colorCycle = {
                white, floralWhite, gray30,gray80,
                red, darkRed, firebrick, crimson, tomato, salmon, lightSalmon, darkSalmon, // Red shades
                orange, darkOrange, coral, tomatoRed, // Orange shades
                yellow, lightYellow, lemonChiffon, lightGoldenrod, papayaWhip, moccasin, // Yellow shades
                green, darkGreen, forestGreen, limeGreen, lightGreen, paleGreen, springGreen, mediumSpringGreen, // Green shades
                aqua, cyan, lightCyan, paleTurquoise, aquamarine, turquoise, mediumTurquoise, darkTurquoise, // Cyan shades
                blue, mediumBlue, darkBlue, navy, royalBlue, dodgerBlue, deepSkyBlue, skyBlue, lightSkyBlue, powderBlue, // Blue shades
                purple, indigo, violet, orchid, plum, thistle, lavender, // Purple shades
                pink, lightPink, hotPink, deepPink, paleVioletRed, mediumVioletRed // Pink shades
        };

        return colorCycle[value % colorCycle.length];
    }

}