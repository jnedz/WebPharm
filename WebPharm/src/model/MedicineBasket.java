package model;

public class MedicineBasket {

		private String title = "";
		private int count;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}


		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		@Override
		public String toString() {

			return "\nTitle: " + getTitle() +"; count: " + getCount();
		}

}
