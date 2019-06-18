package com.kristia_pembelajaran_videografi.kristia_videografi.kuis;

public class QuistionBank {
    private String textQuestions [] = {
            "1. Menyeimbangkan cahaya dalam fotografi dikenal dengan istilah ?",
            "2. Depth of field adalah ?",
            "3. Depth of field dikontrol oleh ?",
            "4. Istilah mana yang digunakan untuk alat di dalam lensa yang fungsinya mengontrol jumlah cahaya yang masuk ?",
            "5. Filter mana yang kamu gunakan untuk membuat langit tampak lebih gelap sementara awan akan terlihat lebih jelas?",
            "6. Jumlah area terang dan gelap dalam sebuah foto dikenal dengan istilah:",
            "7. Jika memotret dengan kondisi low light atau cahaya redup, maka ISO sebaiknya:",
            "8. Exposure yang sempurna adalah hasil gabungan yang tepat dari:",
            "9. Apakah satuan ukuran cahaya dalam fotografi?",
            "10. Dalam ukuran apa bukaan aperture dihitung?"
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"White Balance","Aperture","Shutter Speed" ,"Exposure"},
            {"Sebuah istilah dalam fotografi landscape","Jarak antara kamera dengan objek","Jumlah fokus dan ketajaman dalam sebuah foto","Jarak antara kamera dengan lensa"},
            {"Ukuran focal length pada lensa","Ukuran bukaan aperture","Jarak antara kamera dengan lensa","Semua jawaban benar"},
            {"Concentric","Diafragma","Adjustment","Sensor"},
            {"Neutral Density filter","Polarizing filter","Ultra violet filter","Blue filter"},
            {"Exposure","Shutter speed","Kontras","Sharpness"},
            { "Pada setting paling tinggi yang disediakan oleh kamera","Pada setting paling rendah yang disediakan oleh kamera","Antara 400 hingga 800","Sekitar f/2.8"},
            {"Shutter speed + aperture + resolusi","ISO + aperture + exposure","Exposure + aperture + shutter speed","Aperture + shutter speed + ISO"},
            { "Aperture","Shutter speed","Stop","Histogram"},
            {"Spot","Stop","F/","Detik"}
    };

    private String mCorrectAnswers[] = {"Exposure", "Jumlah fokus dan ketajaman dalam sebuah foto", "Ukuran bukaan aperture", "Diafragma", "Neutral Density filter","Kontras",
            "Antara 400 hingga 800","Aperture + shutter speed + ISO","Stop","F/"};

    public int getLength(){
        return textQuestions.length;
    }

    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
