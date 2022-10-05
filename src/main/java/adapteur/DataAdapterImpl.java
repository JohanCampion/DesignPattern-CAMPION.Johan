package adapteur;

public class DataAdapterImpl implements DataAdapter {

    private HexadecimalData objectWhoServHexadecimal;

    public DataAdapterImpl(HexadecimalData objectWhoServHexadecimal) {
        this.objectWhoServHexadecimal = objectWhoServHexadecimal;
    }

    @Override
    public byte[] getData() {
        return hexStringToByteArray(objectWhoServHexadecimal.getData());
    }

    // Convert Hexadecimal string to byte Array
    public static byte[] hexStringToByteArray(String s) {
        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(s.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
    }
}
