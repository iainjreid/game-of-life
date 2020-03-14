import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.IntStream.range;
import static java.util.stream.Collectors.toList;

class GameOfLife {
  public static class Grid {
    public List<Line> lines;

    public Grid(List<Line> lines) {
      this.lines = lines;
    }

    public static Grid from(List<List<Integer>> lines) {
      return new Grid(lines.stream().map(Line::from).collect(toList()));
    }

    public void show() {
      System.out.print("\033[H\033[2J");
      System.out.print(format());
    }

    public void step() {
      List<Line> nextLines = new ArrayList();

      range(0, lines.size()).forEachOrdered(y -> {
        List<Cell> nextCells = new ArrayList();

        range(0, lines.get(y).cells.size()).forEachOrdered(x -> {
          // Grab a reference of the current Cell at the given position
          Cell currentCell =  lines.get(y).cells.get(x);

          // Retrieve a count of the live neighbours
          Integer liveNeighbours = currentCell.countLiveNeighbours(this, y, x);

          // Depending on state of the current Cell, and how many live neighbours it has, create a new Cell with a new state
          if (currentCell.state == 1) {
            if (liveNeighbours == 3 || liveNeighbours == 2) {
              nextCells.add(new Cell(1));
            } else {
              nextCells.add(new Cell(0));
            }
          } else {
            if (liveNeighbours == 3) {
              nextCells.add(new Cell(1));
            } else {
              nextCells.add(new Cell(0));
            }
          }
        });

        nextLines.add(new Line(nextCells));
      });

      lines = nextLines;
    }

    public String format() {
      return lines.stream().map(Line::format).reduce("", (a, b) -> a + "\n" + b);
    }
  }

  public static class Line {
    public List<Cell> cells;

    public Line(List<Cell> cells) {
      this.cells = cells;
    }

    public static Line from (List<Integer> cells) {
      return new Line(cells.stream().map(cell -> new Cell(cell)).collect(toList()));
    }

    public String format() {
      return cells.stream().map(Cell::format).reduce("", (a, b) -> a + b);
    }
  }

  public static class Cell {
    private Integer state;

    public Cell(Integer state) {
      this.state = state;
    }

    public String format() {
      return state == 1 ? "██" : "  ";
    }

    public Integer countLiveNeighbours(Grid grid, Integer y, Integer x) {
      List<Integer> neighbours = new ArrayList();

      Integer ymin = Math.max(0, y-1);
      Integer xmin = Math.max(0, x-1);

      Integer ymax = Math.min(grid.lines.size(), y+2);
      Integer xmax = Math.min(grid.lines.get(y).cells.size(), x+2);

      range(ymin, ymax).forEach(dy -> {
        range(xmin, xmax).forEach(dx -> {
          if (dy != y || dx != x) {
            neighbours.add(grid.lines.get(dy).cells.get(dx).state);
          }
        });
      });

      return neighbours.stream().reduce(0, Integer::sum);
    }
  }

  public static void main(String[] args) {
    Grid grid = Grid.from(List.of(
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(1,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
      List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    ));

    while (true) {
      grid.show();
      grid.step();

      try {
        Thread.sleep(100);
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
