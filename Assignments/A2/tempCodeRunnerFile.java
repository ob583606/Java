boolean same = false;
		if (a1.length == a2.length) {
			same = true;
			int i = 0;
			while (i < a1.length && same == true) {
				if (!a1[i].equals(a2[i])) {
					same = false;
				}
				i++;
			}			
		}