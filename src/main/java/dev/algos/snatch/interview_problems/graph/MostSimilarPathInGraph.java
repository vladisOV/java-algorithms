package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MostSimilarPathInGraph {

    public static void main(String[] args) {
        var instance = new MostSimilarPathInGraph();
        System.out.println(instance.mostSimilar(75,
                new int[][]{{73, 70}, {24, 69}, {32, 22}, {48, 29}, {59, 71}, {7, 21}, {5, 12}, {74, 12}, {71, 69}, {61, 40}, {62, 49}, {17, 47}, {28, 46}, {9, 6}, {10, 26}, {40, 50}, {33, 25}, {18, 26}, {26, 43}, {58, 7}, {36, 72}, {69, 5}, {69, 67}, {25, 50}, {42, 41}, {61, 66}, {58, 66}, {52, 43}, {49, 65}, {14, 30}, {60, 62}, {56, 55}, {40, 27}, {32, 18}, {65, 68}, {70, 25}, {60, 23}, {46, 39}, {24, 38}, {39, 17}, {16, 18}, {33, 28}, {66, 27}, {50, 37}, {34, 53}, {14, 4}, {49, 71}, {61, 67}, {7, 74}, {26, 72}, {59, 66}, {61, 45}, {60, 35}, {35, 0}, {42, 26}, {61, 44}, {66, 29}, {53, 62}, {4, 54}, {19, 56}, {74, 68}, {12, 54}, {57, 62}, {62, 74}, {28, 49}, {54, 59}, {67, 58}, {9, 50}, {37, 20}, {45, 24}, {56, 72}, {57, 33}, {13, 6}, {28, 60}, {67, 46}, {26, 33}, {55, 12}, {7, 35}, {60, 31}, {47, 51}, {50, 21}, {9, 67}, {53, 10}, {46, 62}, {26, 34}, {53, 71}, {61, 38}, {61, 68}, {2, 18}, {24, 49}, {30, 38}, {39, 60}, {38, 43}, {18, 4}, {49, 25}, {11, 15}, {55, 43}, {48, 52}, {35, 36}, {33, 35}, {63, 57}, {30, 31}, {45, 44}, {6, 31}, {32, 29}, {58, 59}, {34, 16}, {62, 19}, {2, 28}, {38, 48}, {24, 27}, {34, 47}, {72, 73}, {73, 71}, {69, 25}, {49, 33}, {73, 56}, {52, 49}, {21, 51}, {44, 63}, {30, 2}, {13, 62}, {35, 47}, {53, 18}, {0, 56}, {31, 51}, {67, 28}, {11, 10}, {63, 48}, {4, 40}, {40, 58}, {6, 19}, {34, 45}, {69, 45}, {15, 48}, {5, 10}, {9, 70}, {28, 29}, {60, 45}, {6, 0}, {64, 15}, {41, 23}, {29, 38}, {24, 28}, {22, 31}, {42, 20}, {34, 72}, {38, 58}, {30, 48}, {47, 14}, {11, 20}, {35, 54}, {51, 35}, {33, 19}, {57, 24}, {1, 51}, {49, 36}, {43, 29}, {7, 67}, {54, 51}, {35, 43}, {39, 62}, {1, 61}, {69, 48}, {20, 41}, {46, 12}, {69, 21}, {24, 42}, {42, 38}, {28, 48}, {5, 60}, {24, 68}, {43, 42}, {54, 17}, {7, 27}, {8, 32}, {72, 61}, {32, 60}, {67, 21}, {63, 56}, {2, 60}, {65, 19}, {62, 72}, {10, 64}, {66, 63}, {62, 71}, {3, 69}, {54, 37}, {15, 17}, {68, 67}, {24, 40}, {71, 63}, {36, 40}, {17, 5}, {41, 40}, {5, 52}, {39, 72}, {27, 69}, {4, 62}, {16, 64}, {51, 24}, {32, 41}, {24, 36}, {63, 24}, {5, 55}, {13, 31}, {40, 23}, {10, 42}, {55, 61}, {38, 28}, {6, 65}, {21, 13}, {67, 74}, {71, 56}, {19, 71}, {49, 57}, {58, 13}, {37, 67}, {18, 34}, {52, 44}, {14, 8}, {25, 8}, {36, 14}, {70, 4}, {71, 25}, {49, 15}, {71, 17}, {2, 24}, {37, 28}, {69, 57}, {39, 71}, {41, 58}, {43, 31}, {41, 12}, {35, 26}, {53, 73}, {45, 40}, {69, 16}, {27, 51}, {28, 73}, {33, 37}, {44, 26}, {14, 73}, {63, 1}, {47, 53}, {24, 54}, {65, 63}, {34, 68}, {42, 70}, {72, 69}, {65, 45}, {73, 22}, {1, 48}, {60, 67}, {33, 15}, {20, 5}, {51, 7}, {25, 74}, {4, 17}, {28, 15}, {67, 63}, {70, 74}, {49, 18}, {62, 31}, {46, 73}, {42, 52}, {5, 3}, {35, 74}, {14, 12}, {0, 72}, {32, 21}, {67, 39}, {31, 4}, {27, 20}, {32, 43}, {30, 42}, {19, 28}, {73, 69}, {59, 65}, {2, 38}, {56, 11}, {29, 9}, {72, 63}, {42, 16}, {43, 66}, {15, 60}, {21, 73}, {57, 55}, {63, 36}, {48, 70}, {65, 74}, {31, 48}, {32, 35}, {59, 51}, {65, 21}, {40, 39}, {44, 59}, {69, 31}, {19, 70}, {66, 8}, {56, 60}, {33, 64}, {5, 19}, {13, 52}, {26, 39}, {58, 10}, {44, 20}, {66, 74}, {59, 20}, {7, 6}, {17, 69}, {31, 59}, {47, 40}, {65, 40}, {73, 23}, {0, 57}, {54, 30}, {48, 40}, {55, 69}, {22, 41}, {71, 24}, {68, 49}, {36, 42}, {21, 29}, {68, 46}, {72, 25}, {59, 69}, {56, 38}, {56, 21}, {19, 57}, {41, 49}, {48, 49}, {49, 44}, {0, 61}, {56, 58}, {69, 38}, {32, 59}, {53, 30}, {23, 29}, {72, 68}, {33, 20}, {7, 24}, {21, 62}, {5, 24}, {73, 50}, {13, 30}, {64, 62}, {50, 16}, {3, 45}, {55, 59}, {5, 32}, {73, 64}, {33, 58}, {5, 4}, {54, 60}, {63, 16}, {36, 62}, {51, 60}, {61, 21}, {65, 69}, {22, 8}, {48, 71}, {1, 49}, {60, 69}, {48, 72}, {22, 33}, {50, 48}, {13, 29}, {44, 21}, {61, 71}, {51, 55}, {63, 53}, {37, 52}, {37, 14}, {22, 35}, {54, 70}, {47, 44}, {31, 10}, {18, 66}, {65, 18}, {71, 14}, {16, 21}, {67, 18}, {38, 53}, {47, 49}, {32, 64}, {65, 41}, {63, 5}, {40, 37}, {64, 59}, {61, 22}, {22, 46}, {50, 55}, {45, 63}, {72, 64}, {58, 19}, {35, 27}, {14, 16}, {8, 56}, {36, 65}, {26, 62}, {46, 45}, {31, 32}, {56, 74}, {58, 60}, {0, 19}, {16, 22}, {45, 53}, {38, 57}, {9, 4}, {31, 14}, {22, 58}, {21, 23}, {35, 71}, {43, 59}, {30, 5}, {20, 38}, {5, 43}, {66, 22}, {30, 46}, {13, 23}, {32, 0}, {17, 42}, {5, 27}, {49, 56}, {46, 49}, {74, 50}, {11, 69}, {65, 71}, {36, 25}, {21, 58}, {26, 54}, {9, 53}, {46, 66}, {68, 57}, {53, 59}, {52, 59}, {72, 32}, {71, 41}, {24, 44}, {60, 64}, {37, 29}, {45, 70}, {23, 47}, {63, 68}, {67, 50}, {41, 10}, {55, 37}, {1, 32}, {50, 71}, {4, 33}, {9, 17}, {73, 63}, {56, 17}, {18, 31}, {45, 19}, {65, 32}, {62, 68}, {52, 62}, {20, 50}, {53, 23}, {62, 7}, {55, 17}, {44, 51}, {59, 41}, {58, 1}, {70, 11}, {58, 61}, {44, 55}, {52, 55}, {72, 49}, {29, 36}, {25, 54}, {66, 6}, {34, 59}, {1, 5}, {71, 11}, {25, 51}, {68, 48}, {59, 17}, {7, 69}, {68, 26}, {37, 64}, {40, 12}, {21, 12}, {50, 7}, {63, 55}, {68, 56}, {34, 66}, {3, 40}, {59, 42}, {55, 23}, {29, 74}, {54, 1}, {64, 69}, {35, 15}, {66, 32}, {72, 31}, {69, 12}, {70, 72}, {17, 2}, {65, 43}, {33, 69}, {20, 61}, {35, 45}, {37, 66}, {30, 33}, {67, 10}, {4, 57}, {49, 43}, {37, 60}, {3, 17}, {38, 72}, {10, 54}, {40, 68}, {61, 64}, {2, 58}, {50, 41}, {66, 60}, {38, 68}, {74, 23}, {59, 47}, {26, 60}, {21, 66}, {34, 21}, {69, 30}, {46, 48}, {54, 55}, {74, 69}, {15, 0}, {56, 35}, {23, 68}, {68, 45}, {8, 43}, {45, 72}, {43, 13}, {2, 62}, {31, 41}, {16, 46}, {48, 54}, {33, 43}, {11, 55}, {61, 8}, {69, 63}, {24, 55}, {57, 18}, {67, 73}, {22, 53}, {33, 59}, {28, 59}, {9, 34}, {1, 36}, {65, 70}, {14, 9}, {54, 57}, {67, 64}, {52, 46}, {3, 8}, {60, 74}, {33, 72}, {47, 48}, {47, 37}, {41, 13}, {43, 36}, {62, 44}, {34, 22}, {73, 32}, {62, 48}, {42, 27}, {74, 52}, {68, 0}, {6, 16}, {52, 40}, {67, 5}, {10, 6}, {36, 15}, {63, 49}, {74, 51}, {5, 34}, {30, 41}, {50, 52}, {57, 71}, {40, 6}, {73, 33}, {41, 64}, {5, 70}, {16, 60}, {68, 73}, {59, 37}, {16, 53}, {50, 65}, {22, 6}, {62, 63}, {62, 12}, {24, 16}, {36, 12}, {52, 36}, {2, 53}, {32, 44}, {31, 50}, {30, 57}, {29, 69}, {35, 46}, {33, 52}, {67, 30}, {71, 68}, {73, 65}, {36, 66}, {66, 16}, {72, 52}, {35, 53}, {51, 40}, {38, 6}, {6, 34}, {63, 40}, {65, 64}, {72, 74}, {74, 40}, {19, 10}, {19, 11}, {39, 68}, {38, 18}, {67, 14}, {60, 33}, {3, 28}, {23, 52}, {45, 43}, {21, 59}, {67, 55}, {39, 50}, {11, 21}, {37, 69}, {33, 31}, {66, 65}, {61, 17}, {71, 37}, {11, 26}, {64, 71}, {28, 65}, {30, 49}, {60, 68}, {17, 50}, {28, 55}, {3, 16}, {66, 35}, {39, 56}, {47, 32}, {8, 45}, {35, 39}, {30, 6}, {51, 38}, {70, 34}, {8, 42}, {25, 0}, {11, 46}, {72, 71}, {43, 58}, {58, 62}, {14, 52}, {34, 63}, {23, 67}, {61, 42}, {50, 3}, {71, 26}, {18, 19}, {70, 44}, {62, 56}, {34, 50}, {58, 46}, {50, 56}, {18, 60}, {44, 11}, {61, 70}, {74, 47}, {65, 57}, {68, 42}, {57, 61}, {73, 54}, {64, 39}, {62, 66}, {60, 20}, {48, 51}, {33, 70}, {22, 70}, {3, 35}, {13, 40}, {60, 63}, {62, 61}, {2, 54}, {32, 33}, {25, 39}, {64, 54}, {0, 55}, {63, 46}, {58, 74}, {45, 57}, {27, 15}, {48, 73}, {11, 6}, {52, 12}, {65, 17}, {57, 67}, {66, 38}, {64, 57}, {35, 70}, {38, 32}, {42, 67}, {19, 8}, {6, 50}, {47, 31}, {7, 65}, {28, 72}, {10, 61}, {44, 23}, {33, 66}, {31, 55}, {3, 14}, {50, 30}, {52, 71}, {56, 64}, {39, 70}, {6, 26}, {13, 24}, {36, 33}, {21, 3}, {73, 42}, {4, 58}, {74, 59}, {13, 33}, {59, 3}, {42, 46}, {49, 73}, {55, 48}, {45, 48}, {7, 52}, {65, 27}, {68, 43}, {42, 18}, {7, 11}, {12, 71}, {43, 16}, {36, 10}, {23, 19}, {56, 41}, {9, 48}, {58, 69}, {25, 52}, {12, 13}, {17, 48}, {45, 30}, {51, 56}, {65, 58}, {6, 56}, {46, 74}, {58, 34}, {12, 10}, {65, 1}, {39, 69}, {70, 43}, {54, 63}, {7, 70}, {65, 72}, {67, 54}, {70, 16}, {56, 34}, {72, 6}, {33, 53}, {60, 3}, {44, 53}, {38, 14}, {36, 44}, {32, 61}, {51, 65}, {64, 70}, {56, 22}, {8, 51}, {58, 57}, {17, 0}, {36, 13}, {73, 52}, {13, 38}, {16, 17}, {69, 68}, {22, 24}, {40, 49}, {65, 44}, {65, 3}, {61, 51}, {36, 54}, {72, 22}, {36, 0}, {50, 33}, {65, 35}, {27, 4}, {54, 8}, {31, 49}, {33, 3}, {29, 22}, {21, 25}, {49, 50}, {14, 11}, {39, 57}, {21, 18}, {71, 46}, {23, 72}, {67, 49}, {19, 12}, {69, 62}, {37, 22}, {52, 64}, {55, 1}, {8, 67}, {52, 53}, {53, 68}, {45, 49}, {31, 73}, {10, 60}, {61, 69}, {26, 21}, {60, 71}, {68, 37}, {39, 44}, {29, 3}, {66, 68}, {2, 72}, {4, 6}, {28, 42}, {21, 42}, {74, 73}, {58, 63}, {61, 28}, {67, 26}, {20, 46}, {36, 6}, {44, 54}, {39, 47}, {7, 46}, {50, 62}, {54, 66}, {63, 42}, {3, 27}, {61, 59}, {45, 2}, {40, 54}, {41, 68}, {29, 68}, {32, 70}, {59, 12}, {46, 72}, {33, 27}, {33, 0}, {29, 72}, {37, 41}, {40, 42}, {33, 45}, {40, 1}, {0, 34}, {65, 24}, {65, 53}, {53, 49}, {70, 59}, {65, 12}, {37, 9}, {12, 51}, {66, 67}, {15, 62}, {34, 24}, {60, 48}, {13, 5}, {30, 61}, {53, 60}, {10, 0}, {58, 73}, {50, 12}, {22, 50}, {48, 12}, {66, 1}, {68, 47}, {57, 11}, {73, 20}, {73, 43}, {23, 58}, {56, 48}, {71, 5}, {41, 45}, {9, 55}, {2, 74}, {38, 70}, {70, 67}, {33, 47}, {33, 34}, {30, 12}, {2, 4}, {25, 26}, {17, 30}, {62, 59}, {73, 51}, {31, 16}, {56, 24}, {72, 53}, {49, 0}, {61, 49}, {39, 5}, {15, 18}, {20, 16}, {34, 27}, {61, 34}, {72, 47}, {6, 23}, {44, 66}, {64, 48}, {47, 70}, {12, 47}, {2, 41}, {72, 67}, {36, 73}, {43, 20}, {41, 62}, {7, 10}, {54, 16}, {31, 23}, {65, 31}, {11, 34}, {50, 44}, {39, 52}, {13, 35}, {8, 7}, {22, 67}, {43, 14}, {67, 31}, {62, 35}, {10, 68}, {65, 54}, {74, 3}, {7, 41}, {42, 57}, {48, 61}, {24, 61}, {73, 66}, {69, 56}, {59, 46}, {13, 61}, {42, 74}, {8, 53}, {57, 56}, {49, 11}, {47, 13}, {21, 37}, {56, 18}, {52, 54}, {8, 47}, {63, 15}, {72, 43}, {23, 59}, {43, 74}, {56, 47}, {33, 24}, {57, 31}, {4, 55}, {57, 34}, {13, 64}, {62, 65}, {44, 43}, {71, 44}, {64, 68}, {16, 41}, {67, 51}, {41, 19}, {48, 16}, {58, 27}, {39, 59}, {32, 62}, {12, 4}, {4, 53}, {69, 49}, {25, 64}, {68, 50}, {49, 26}, {57, 7}, {10, 49}, {2, 0}, {44, 37}, {28, 64}, {63, 70}, {28, 8}, {62, 70}, {39, 15}, {11, 28}, {26, 56}, {17, 12}, {70, 49}, {20, 13}, {22, 68}, {30, 7}, {28, 52}, {48, 43}, {11, 41}, {45, 39}, {51, 71}, {72, 50}, {51, 66}, {72, 66}, {69, 54}, {50, 57}, {17, 35}, {9, 59}, {46, 50}, {52, 70}, {44, 64}, {51, 17}, {41, 8}, {60, 1}, {34, 30}, {11, 22}, {20, 72}, {74, 63}, {54, 72}, {29, 62}, {56, 70}, {37, 36}, {35, 28}, {23, 4}, {55, 2}, {45, 25}, {26, 58}, {39, 49}, {27, 64}, {15, 7}, {36, 18}, {74, 64}, {36, 59}, {15, 72}, {24, 17}, {2, 39}, {21, 68}, {11, 18}, {49, 60}, {4, 50}, {73, 37}, {70, 68}, {22, 57}, {25, 40}, {28, 47}, {69, 70}, {39, 58}, {54, 74}, {63, 28}, {55, 58}, {74, 71}, {47, 22}, {58, 47}, {56, 7}, {32, 28}, {63, 35}, {71, 70}, {2, 44}, {47, 66}, {61, 23}, {27, 63}, {64, 63}, {20, 24}, {43, 46}, {59, 72}, {71, 32}, {44, 27}, {41, 46}, {41, 14}, {47, 65}, {37, 13}, {24, 66}, {74, 4}, {45, 14}, {38, 62}, {39, 16}, {50, 28}, {55, 71}, {12, 57}, {47, 27}, {10, 24}, {25, 16}, {65, 56}, {14, 32}, {37, 23}, {57, 59}, {22, 74}, {56, 61}, {1, 50}, {0, 44}, {40, 69}, {33, 10}, {18, 35}, {53, 67}, {65, 26}, {69, 66}, {60, 59}, {60, 7}, {49, 54}, {14, 50}, {40, 59}, {71, 13}, {2, 25}, {63, 3}, {48, 65}, {64, 42}, {37, 63}, {56, 25}, {26, 17}, {26, 12}, {52, 16}, {40, 60}, {39, 10}, {44, 28}, {73, 57}, {50, 53}, {37, 17}, {43, 18}, {24, 70}, {28, 57}, {35, 61}, {57, 53}, {14, 29}, {54, 42}, {25, 35}, {46, 29}, {24, 73}, {52, 56}, {8, 55}, {56, 53}, {11, 43}, {51, 68}, {27, 70}, {5, 44}, {19, 32}, {8, 26}, {63, 13}, {72, 57}, {38, 40}, {31, 5}, {57, 52}, {64, 51}, {15, 73}, {35, 69}, {42, 35}, {63, 47}, {27, 17}, {38, 45}, {7, 29}, {21, 0}, {27, 25}, {54, 71}, {37, 35}, {15, 65}, {67, 56}, {74, 57}, {74, 19}, {71, 66}, {32, 37}, {49, 20}, {35, 8}, {14, 54}, {53, 58}, {23, 9}, {42, 14}, {45, 1}, {5, 41}, {61, 73}, {5, 68}, {41, 54}, {45, 51}, {67, 59}, {11, 74}, {72, 17}, {71, 15}, {51, 46}, {12, 2}, {65, 67}, {10, 17}, {22, 54}, {30, 24}, {31, 68}, {52, 31}, {38, 36}, {51, 50}, {29, 49}, {31, 44}, {53, 43}, {35, 29}, {14, 39}, {53, 39}, {44, 34}, {26, 28}, {58, 44}, {30, 37}, {27, 52}, {52, 61}, {47, 41}, {66, 42}, {34, 60}, {51, 26}, {17, 11}, {14, 49}, {52, 38}, {66, 64}, {46, 64}, {30, 65}, {8, 20}, {35, 55}, {71, 45}, {60, 55}, {70, 12}, {23, 70}, {72, 4}, {50, 47}, {49, 74}, {64, 47}, {61, 63}, {18, 12}, {54, 58}, {23, 38}, {34, 74}, {48, 25}, {25, 46}, {43, 9}, {0, 1}, {28, 31}, {9, 35}, {39, 18}, {70, 66}, {55, 3}, {51, 14}, {62, 22}, {16, 58}, {28, 25}, {25, 10}, {44, 68}, {56, 66}, {16, 61}, {57, 60}, {25, 18}, {58, 70}, {54, 3}, {22, 13}, {62, 67}, {55, 53}, {64, 0}, {13, 66}, {54, 50}, {72, 21}, {71, 18}, {68, 58}, {43, 4}, {4, 26}, {52, 63}}
                , new String[]{"SCM", "DET", "MLW", "BLI", "MLF", "DAM", "KTM", "UVF", "KGF", "PHE", "EZE", "BJM", "EZE", "BJM", "YPR", "UVF", "DET", "EZE", "DET", "CPO", "SXB", "ANU", "JKT", "ABY", "BJM", "ABY", "MLW", "PHE", "SXB", "JFK", "TUN", "YPR", "YAP", "ELM", "UVF", "UVF", "PHE", "KGF", "PYH", "FKI", "MLW", "NGS", "MLW", "SXB", "KTM", "EMB", "ELM", "WBU", "KGF", "BJM", "YAP", "JFK", "FKI", "PHE", "BET", "EZE", "GDX", "BET", "PYH", "BET", "SGU", "ABY", "FKI", "NGS", "IRP", "PYH", "PYH", "UVF", "IRP", "TNA", "BET", "WBU", "DET", "SXB", "SGU"}
                , new String[]{"TNA", "EZE", "KTM", "ABY", "FKI", "WBU", "BET", "PHE", "BET", "MLW", "WBU", "JFK", "ELM", "SXB", "KGF", "IRP", "ABY", "SGU", "GDX", "UVF", "IRP", "UVF", "TUN", "BJM", "BJM", "ABY", "NGS", "SXB", "KGF", "UVF", "ABY", "YPR", "PYH", "GDX", "IRP", "YAP", "UVF", "PHE", "JFK", "ABY", "TNA", "DET", "UVF", "YPR", "JFK", "TNA", "BET", "WBU", "YPR", "DET"}));
    }

    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] target) {
        int m = target.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for (int[] road : roads) {
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        int[][] dist = new int[n][m];
        int[][] prev = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(prev[i], -1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> dist[a[0]][a[1]] - dist[b[0]][b[1]]);
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{i, 0});
            dist[i][0] = !names[i].equals(target[0]) ? 1 : 0;
            for (int j = 1; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int node = data[0];
            int tIndex = data[1];
            if (tIndex == m - 1) continue;
            int distance = dist[node][tIndex];

            for (int adj : map.get(node)) {
                int diff = !names[adj].equals(target[tIndex + 1]) ? 1 : 0;
                if (distance + diff < dist[adj][tIndex + 1]) {
                    dist[adj][tIndex + 1] = diff + distance;
                    prev[adj][tIndex + 1] = node;
                    queue.add(new int[]{adj, tIndex + 1});
                }
            }
        }
        int minDiff = m + 1, minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (minDiff >= dist[i][m - 1]) {
                minDiff = dist[i][m - 1];
                minIndex = i;
            }
        }
        List<Integer> ans = new LinkedList<>();
        int prevIndex = minIndex;
        for (int j = m - 1; j >= 0; j--) {
            ans.add(0, prevIndex);
            prevIndex = prev[prevIndex][j];
        }
        return ans;
    }
//
//    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            map.put(i, new ArrayList<>());
//        }
//        for (int[] road : roads) {
//            map.get(road[0]).add(road[1]);
//            map.get(road[1]).add(road[0]);
//        }
//
//        boolean[][][] visited = new boolean[n][targetPath.length + 1][targetPath.length + 1];
//        ResultPath result = new ResultPath(targetPath.length);
//        for (int i = 0; i < n; i++) {
//            helper(i, 0, 0, map, new ArrayList<>(), result, visited, names, targetPath);
//        }
//        return result.path;
//    }
//
//    void helper(int i, int j, int diff, Map<Integer, List<Integer>> map, List<Integer> path, ResultPath result,
//                boolean[][][] visited, String[] names, String[] target) {
//        if (visited[i][j][diff]) return;
//        visited[i][j][diff] = true;
//        if (path.size() == target.length) {
//            if (diff <= result.diff) {
//                result.diff = diff;
//                result.path = new ArrayList<>(path);
//            }
//            return;
//        }
//        if (diff > result.diff) return;
//        path.add(i);
//        if (!target[j].equals(names[i])) diff++;
//        for (var adj : map.get(i)) {
//            helper(adj, j + 1, diff, map, path, result, visited, names, target);
//        }
//        path.remove(path.size() - 1);
//    }
//
//    static class ResultPath {
//        int diff;
//        List<Integer> path;
//
//        public ResultPath(int diff) {
//            this.diff = diff;
//            this.path = new ArrayList<>();
//        }
//    }
}
