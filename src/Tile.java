public abstract class Tile {

    int tileCords;
    Tile(int tileCords) {
        this.tileCords = tileCords;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile {
        EmptyTile(int cords) {
            super(cords);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }




    }
    public static final class OccupiedTile extends Tile {
        Piece pieceOnTile;

        OccupiedTile(int tileCords, Piece pieceOnTile) {
            super(tileCords);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }


}
