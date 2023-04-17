package pl.devcezz.jasper;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pl.devcezz.jasper.Position.ATTACKER;
import static pl.devcezz.jasper.Position.DEFENDER;
import static pl.devcezz.jasper.Position.MIDFIELD;

public class JasperMain {

    private static final String FILE_NAME = "src/main/resources/jasper-design.jrxml";
    private static final String OUT_FILE = "src/main/resources/football-report.pdf";

    public static void main(String[] args) throws JRException, FileNotFoundException {
        List<FootballPlayer> footballPlayers = List.of(
                FootballPlayer.of("Leo", "Messi", ATTACKER),
                FootballPlayer.of("Mason", "Mount", MIDFIELD),
                FootballPlayer.of("Mats", "Hummels", DEFENDER)
        );
        List<FootballClub> footballClubs = List.of(
                FootballClub.of("Paris Saint-Germain", "France"),
                FootballClub.of("Chelsea London", "England"),
                FootballClub.of("Borussia Dortmund", "Germany")
        );

        JRBeanCollectionDataSource footballPlayersCollectionDataSource =
                new JRBeanCollectionDataSource(footballPlayers);
        JRBeanCollectionDataSource footballClubsCollectionDataSource =
                new JRBeanCollectionDataSource(footballClubs);

        Map<String, Object> parameters = Map.of(
                "title", "Players and their current clubs",
                "footballPlayersDataSource", footballPlayersCollectionDataSource,
                "footballClubsDataSource", footballClubsCollectionDataSource
        );

        JasperReport jasperDesign = JasperCompileManager.compileReport(FILE_NAME);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperDesign,
                new HashMap<>(parameters),
                new JREmptyDataSource());

        File file = new File(OUT_FILE);
        OutputStream outputSteam = new FileOutputStream(file);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputSteam);

        System.out.println("Football report successfully generated!");
    }
}
