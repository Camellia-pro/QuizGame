package sample;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Rectangle;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MosaicController implements Initializable {

    @FXML Button Back;
    @FXML Button Save;
    @FXML Canvas canvasMosaic;
    @FXML Label labelCount;

    final int mosaicWidth = 611;
    final int mosaicHeight = 798;

    final int mosaicCols = 5;
    final int mosaicRows = 5;

    final double mosaicSectorWidth = mosaicWidth / mosaicCols;
    final double mosaicSectorHeight = mosaicHeight  / mosaicRows;

    private boolean[] sectors = new boolean[mosaicRows * mosaicCols];

    private int sectorsToOpen = 0;


    private void drawBlack() {
        GraphicsContext gc = canvasMosaic.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, mosaicWidth, mosaicHeight);
    }

    private int getSecrotNumByCoords(double x, double y) {
        Double f = Math.floor(x / mosaicSectorWidth) + mosaicCols * Math.floor(y / mosaicSectorHeight);
        return f.intValue();
    }

    private Rectangle getSectorCoordsByNum(int sectorNum) {
        int row = sectorNum / mosaicCols;
        int col = sectorNum % mosaicCols;

        int x = new Double(Math.floor(col * mosaicSectorWidth)).intValue();
        int y = new Double(Math.floor(row * mosaicSectorHeight)).intValue();
        int w = new Double(Math.floor(mosaicSectorWidth)).intValue();
        int h = new Double(Math.floor(mosaicSectorHeight)).intValue();

        return new Rectangle(x,y,w,h);
    }

    public void saveImg() throws IOException {
        WritableImage image = canvasMosaic.snapshot(null, null);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG images (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(Main.primaryStageStatic);

        if(file != null){
            ImageIO.write(bImage, "png", file);
        }
    }

    public void actionClick(MouseEvent e) {
        double dx = e.getX();
        double dy = e.getY();


        int sectorNum = getSecrotNumByCoords(dx,dy);
        if (sectorsToOpen < 1 || checkSector(sectorNum)) return;
        sectors[sectorNum] = true;
        sectorsToOpen--;
        updateLabel();
        drawSector(sectorNum);
    }

    private void updateLabel() {
        labelCount.setText("Осталось попыток: " + sectorsToOpen);
    }

    public void drawSector(int sectorNum) {
        Rectangle rec = getSectorCoordsByNum(sectorNum);
        GraphicsContext gc = canvasMosaic.getGraphicsContext2D();
        Image imgColor = new Image("sample/last_picture.jpg");
        PixelReader reader = imgColor.getPixelReader();
        WritableImage newImage = new WritableImage(reader, rec.x, rec.y, rec.width, rec.height);
        gc.drawImage(newImage, rec.x, rec.y, rec.width, rec.height);

    }

    private boolean checkSector(int sectorNum) {
        return sectors != null && sectors[sectorNum];
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sectorsToOpen = QuestionController.getCorrectChoise();
        updateLabel();
        drawBlack();
    }
    public void exitGame() {
        System.exit(1);
    }
}
