package sample;

        import javafx.beans.property.StringProperty;


public class TableRowDataModel {
    private StringProperty charts;
    private StringProperty address;
    private StringProperty album;

    public TableRowDataModel(StringProperty charts, StringProperty address, StringProperty album) {
        this.charts = charts;
        this.address = address;
        this.album = album;
    }

    public StringProperty nameProperty() {
        return charts;
    }
    public StringProperty addressProperty() {
        return address;
    }
    public StringProperty albumProperty(){
        return  album;
    }
}