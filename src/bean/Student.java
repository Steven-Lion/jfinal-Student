package bean;

public class Student {
			//属性.
		private int id;
		private String name;
		private String sex;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public Student(int id, String name, String sex, int age, int phone, String location) {
			super();
			this.id = id;
			this.name = name;
			this.sex = sex;
			this.age = age;
			this.phone = phone;
			this.location = location;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", phone=" + phone
					+ ", location=" + location + "]";
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getPhone() {
			return phone;
		}
		public void setPhone(int phone) {
			this.phone = phone;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		private int age;
		private int phone ;
		private String location ;
		
}
