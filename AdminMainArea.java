package LibraryManagement;
import java.io.*;
class AdminMainArea {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name,date,str;
        int id,book,fine;
        String bookname,booktype;
        int bookid,booknum;
        
        
                System.out.println("Welcome To Library Management Forum");
                System.out.println("----------------------------------------");
                System.out.println();
                System.out.println("If you are admin press 1");
                System.out.println();
                System.out.println("If you are member press 2"); 
                System.out.println();
                System.out.println("----------------------------------------");
                int entry1 = Integer.parseInt(br.readLine());
                if(entry1 == 1) {
                System.out.println("Enter admin UserName and PassWord");
                String usn = br.readLine();
                String usn1 = "s";
                String usn2 = "Soumen";
                String pass = br.readLine();
            	String pass1 = "0";
            	String pass2 = "12345";
                if(usn.equals(usn1) && pass.equals(pass1) || usn.equals(usn2) && pass.equals(pass2)) {          
                		System.out.println("Welcome You have successfully login What You want choose");
                		int pop;
                		do {
                        System.out.println("press 1 for add new memeber");
                        System.out.println("press 2 for add new books");
                        System.out.println("press 3 for show member details");
                        System.out.println("press 4 for show Book Details");
                        System.out.println("press 5 for issue any book for member");
                        System.out.println("press 6 for return any book from member to library");
                        System.out.println("press 7 for update fine charge");
                        System.out.println("press 8 for delete any member");
                        System.out.println("press 9 to see member notification");
                        System.out.println("press 0 for exit");
                        pop = Integer.parseInt(br.readLine());
                        if(pop == 1) {
                            System.out.println("Enter No of Member You want to input in registry");
                            File s = new File("Members.dat");
                            File count = new File("Count1.dat");
                            boolean checkin = count.exists();
                            int c = 0;
                            if(checkin) {
                            	 FileInputStream sca1 = new FileInputStream(count);
                         		ObjectInputStream sca = new ObjectInputStream(sca1);
                         		c = (int) sca.readObject();
                         		sca.close();
                            }
                           
                            boolean append = s.exists();
                            try(
                            FileOutputStream  of = new FileOutputStream(s, append);
                            AppendableObjectOutputStream obj = new AppendableObjectOutputStream(of, append);
                            
                            FileOutputStream  of1 = new FileOutputStream(count);
                            ObjectOutputStream obj1 = new ObjectOutputStream(of1);
                            ) {
                            int num = Integer.parseInt(br.readLine());
                            int d = c+num;
                            obj1.writeObject(d);
                            obj1.close();
                            Member ob[] = new Member[num];
                            
                            for(int i=0; i<num ; i++) {
                                System.out.println("Name of the Member");
                                name = br.readLine();
                                System.out.println("Enter any uniq id you set");
                                id = Integer.parseInt(br.readLine());
                                book = 0;
                                date = "Nothing to show";
                                str = "Nothing to show ";
                                fine = 0;
                                ob[i] = new LibraryManagement.Member(name, id, book, date, str,fine);
                                obj.writeObject(ob[i]);
                            }
                            obj.close();
                            }
                            catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if(pop == 2) {
                            File s = new File("BooksRecord.dat");
                            File count = new File("Counter.dat");
                            boolean exist = count.exists();
                            int c = 0;
                            if(exist) {
                            	 FileInputStream sca1 = new FileInputStream(count);
                          		ObjectInputStream sca = new ObjectInputStream(sca1);
                          		c = (int) sca.readObject();
                          		sca.close();
                             }
                            boolean append = s.exists();
                            try (
                            FileOutputStream  of = new FileOutputStream(s, append);
                            AppendableObjectOutputStream obj = new AppendableObjectOutputStream(of,append);
                            
                            
                            FileOutputStream  of1 = new FileOutputStream(count);
                            ObjectOutputStream ohj = new ObjectOutputStream(of1);
                            ) {
                            System.out.println("Enter No of books you want to register");
                            int bookc = Integer.parseInt(br.readLine());
                            int d = c+bookc;
                            ohj.writeObject(d);
                            ohj.close();
                            Books ob[] = new Books[bookc];
                            for(int i=0; i<bookc; i++) {
                            	System.out.println("Enter Book's Name ");
                                bookname = br.readLine();
                                System.out.println("Enter Book's Type");
                                booktype = br.readLine();
                                System.out.println("Enter uniq Book's Id ");
                                bookid = Integer.parseInt(br.readLine());
                                System.out.println("Enter No of quantity you want to add");
                                booknum = Integer.parseInt(br.readLine());
                                ob[i] = new LibraryManagement.Books(bookname, bookid, booktype, booknum);
                                 obj.writeObject(ob[i]);
                                 
                              }
                            obj.close();
                           }
                            catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if(pop == 3) {
                        	File f = new File("Members.dat");
                        	FileInputStream of = new FileInputStream(f);
                    		ObjectInputStream obj = new ObjectInputStream(of);
                    		
                    		File f1 = new File("Count1.dat");
                    		FileInputStream of1 = new FileInputStream(f1);
                    		ObjectInputStream obj1 = new ObjectInputStream(of1);
                    		
                    		int c = (int) obj1.readObject();
                    		LibraryManagement.Member ob[] = new Member[c];
                    		obj1.close();
                    		try {
                    			for(int i=0; i<c; i++) {
                    				ob[i] = (LibraryManagement.Member) obj.readObject();
                    				ob[i].ShowMember();
                    			}
                    		}
                    		catch(Exception e) {
                    			System.out.println(e);
                    		}
                    		obj.close();
                    	   }
                        if(pop == 4) {
                        	File f = new File("BooksRecord.dat");
                        	FileInputStream of = new FileInputStream(f);
                    		ObjectInputStream obj = new ObjectInputStream(of);
                    		File f1 = new File("Counter.dat");
                    		FileInputStream of1 = new FileInputStream(f1);
                    		ObjectInputStream obj1 = new ObjectInputStream(of1);
                    		int c = (int) obj1.readObject();
                    		LibraryManagement.Books ob[] = new Books[c];
                    		obj1.close();
                    		System.out.println();
                    		System.out.println("press 1 to see details of all books");
                    		System.out.println();
                    		System.out.println("press 2 details of customized by type books");
                    		int bc = Integer.parseInt(br.readLine());
                    		if(bc == 1) {
                    			try {
                    				for(int i=0; i<c; i++) {
                    					ob[i] = (LibraryManagement.Books)obj.readObject();
                    					ob[i].ShowBook();
                    				}
                    			}catch(Exception e) {
                    				System.out.println(e);
                    			}
                    			
                    		}
                    		if(bc == 2) {
                    			System.out.println("Enter type of books");
                    			String bt = br.readLine();
                    			try {
                    				int gh = 0;
                    				for(int i=0; i<c; i++) {
                    					ob[i] = (LibraryManagement.Books)obj.readObject();
                    					if(ob[i].type.equals(bt)) {
                    					ob[i].ShowBook();
                    					gh++;
                    					}
                    					if(gh==0) {
                    						System.out.println("Nothing this type books stored in library");
                    					}
                    				}
                    				obj.close();
                    			}
                    			catch(Exception e) {
                    				System.out.println(e);
                    			}
                    		}
                    		
                        }
                        if(pop == 5) {
                        	int membookid = 0;
                        	File f = new File("Members.dat");
                        	FileInputStream of = new FileInputStream(f);
                    		ObjectInputStream obj = new ObjectInputStream(of);
                    		
                    		File f1 = new File("Count1.dat");
                    		FileInputStream of1 = new FileInputStream(f1);
                    		ObjectInputStream obj1 = new ObjectInputStream(of1);
                    		
                    		int c = (int) obj1.readObject();
                    		LibraryManagement.Member ob[] = new Member[c];
                    		obj1.close();
                    		try {
                    			System.out.println("Enter the  member id to give book to him");
                    			int mem = Integer.parseInt(br.readLine());
                    			for(int i=0; i<c; i++) {
                    				ob[i] = (LibraryManagement.Member) obj.readObject();
                    				if(ob[i].Id == mem) {
                    					System.out.println("Enter BookId");
                    					membookid = Integer.parseInt(br.readLine());
                    					ob[i].BookId = membookid;
                    					System.out.println("Date of issue for this book(DD/MM/YYYY)");
                    					String date1 = br.readLine();
                                        ob[i].Date = date1;
                                        String[] arr = date1.split("/",3);
                                        int dt =Integer.parseInt(arr[0]);
                                        int mn = Integer.parseInt(arr[1]);
                                        mn = mn+1;
                                        int yr = Integer.parseInt(arr[2]);
                                        if(mn>12) {
                                        	mn = mn-12;
                                        	yr = yr+1;
                                        }
                                        arr[0] = Integer.toString(dt);
                                        arr[1] = Integer.toString(mn);
                                        arr[2] = Integer.toString(yr);
                                        StringBuilder builder = new StringBuilder();
                                        int k=1;
                                        for(String w : arr) {
                                        	if(k!=3) {
                                        		builder.append(w+"/");
                                        	}
                                        	else {
                                        		builder.append(w);
                                        	}
                                        	k++;
                                        }
                                        ob[i].SubDate = builder.toString();
                    				}
                    			}
                    			obj.close();
                    		}
                    		catch(Exception e) {
                    			System.out.println(e);
                    		}
                    		
                    		File s = new File("Members.dat");
                    		FileOutputStream fa = new FileOutputStream(s);
                    		ObjectOutputStream ffd = new ObjectOutputStream(fa);
                    		for(int i=0; i<c; i++) {
                    			ffd.writeObject(ob[i]);
                    		}
                    		ffd.close();
                    		
                    		
                    		File faa = new File("BooksRecord.dat");
                        	FileInputStream ofa = new FileInputStream(faa);
                    		ObjectInputStream obja = new ObjectInputStream(ofa);
                    		File fad = new File("Counter.dat");
                    		FileInputStream of1a = new FileInputStream(fad);
                    		ObjectInputStream obj11 = new ObjectInputStream(of1a);
                    		int c1 = (int) obj11.readObject();
                    		LibraryManagement.Books ob1[] = new Books[c1];
                    		obj11.close();
                    			try {
                    				for(int i=0; i<c1; i++) {
                    					ob1[i] = (LibraryManagement.Books)obja.readObject();
                    					if(ob1[i].id == membookid) {
                    						ob1[i].count--;
                    					}
                    					
                    				}
                    				obja.close();
                    			} catch(Exception e) {
                    				System.out.println(e);
                    			}
                    			File fq = new File("BooksRecord.dat");
                        		FileOutputStream fz = new FileOutputStream(fq);
                        		ObjectOutputStream fd = new ObjectOutputStream(fz);
                        		for(int i=0; i<c1; i++) {
                        			fd.writeObject(ob1[i]);
                        		}
                        		fd.close();
                        }
                        if(pop == 7) {
                        	System.out.println("press 1 to add fine for member");
                        	System.out.println("press 2 to remove fine for member if he paid");
                        	int fne1 = Integer.parseInt(br.readLine());
                        	if(fne1 == 1) {
                        		
                        		File f = new File("Members.dat");
                            	FileInputStream of = new FileInputStream(f);
                        		ObjectInputStream obj = new ObjectInputStream(of);
                        		
                        		File f1 = new File("Count1.dat");
                        		FileInputStream of1 = new FileInputStream(f1);
                        		ObjectInputStream obj1 = new ObjectInputStream(of1);
                        		
                        		int c = (int) obj1.readObject();
                        		LibraryManagement.Member ob[] = new Member[c];
                        		obj1.close();
                        		  try {
                        			  System.out.println("Enter the id of member");
                              		  int fna = Integer.parseInt(br.readLine());
                              		  for(int i=0; i<c; i++) {
                              			  ob[i] = (LibraryManagement.Member) obj.readObject();
                              			  if(ob[i].Id == fna) {
                              				  System.out.println("Enter amount of fine charge");
                              				  int finh = Integer.parseInt(br.readLine());
                              				  ob[i].Fine = finh;
                              			  }
                              			  obj.close();
                              		  }
                              		
                        		  }catch(Exception e) {
                      				System.out.println(e);
                      			}
                        	    File s = new File("Members.dat");
                          		FileOutputStream fa = new FileOutputStream(s);
                          		ObjectOutputStream ffd = new ObjectOutputStream(fa);
                          		for(int i=0; i<c; i++) {
                          			ffd.writeObject(ob[i]);
                          		}
                          		ffd.close();
                        	}
                        	if(fne1 == 2) {
                        		File f = new File("Members.dat");
                            	FileInputStream of = new FileInputStream(f);
                        		ObjectInputStream obj = new ObjectInputStream(of);
                        		
                        		File f1 = new File("Count1.dat");
                        		FileInputStream of1 = new FileInputStream(f1);
                        		ObjectInputStream obj1 = new ObjectInputStream(of1);
                        		
                        		int c = (int) obj1.readObject();
                        		LibraryManagement.Member ob[] = new Member[c];
                        		obj1.close();
                        		  try {
                        			  System.out.println("Enter the id of member");
                        			  int sf = Integer.parseInt(br.readLine()); 
                              		  for(int i=0; i<c; i++) {
                              			  ob[i] = (LibraryManagement.Member) obj.readObject();
                              			  if(ob[i].Id == sf) {
                              				  System.out.println("Enter the amount he paid");
                              				  int finh = Integer.parseInt(br.readLine());
                              				  ob[i].Fine = ob[i].Fine-finh;
                              			  }
                              			  obj.close();
                              		  }
                              		
                        		  }catch(Exception e) {
                      				System.out.println(e);
                      			}
                        		  File s = new File("Members.dat");
                          		FileOutputStream fa = new FileOutputStream(s);
                          		ObjectOutputStream ffd = new ObjectOutputStream(fa);
                          		for(int i=0; i<c; i++) {
                          			ffd.writeObject(ob[i]);
                          		}
                          		ffd.close();
                        	}
                        }
                        if(pop == 8) {
                        	File f = new File("Members.dat");
                        	FileInputStream of = new FileInputStream(f);
                    		ObjectInputStream obj = new ObjectInputStream(of);
                    		
                    		File f1 = new File("Count1.dat");
                    		FileInputStream of1 = new FileInputStream(f1);
                    		ObjectInputStream obj1 = new ObjectInputStream(of1);
                    		
                    		int c = (int) obj1.readObject();
                    		LibraryManagement.Member ob[] = new Member[c];
                    		obj1.close();
                    		int fg = c-1;
                    		LibraryManagement.Member ob1[] = new Member[fg];
                    		int bookid1 = 0; 
                    		  try {
                    			  System.out.println("Enter the id of member you want to delete");
                          		  int suf = Integer.parseInt(br.readLine());
                          		  int as = 0;
                          		  for(int i=0; i<c; i++) {
                          			  ob[i] = (LibraryManagement.Member) obj.readObject();
                          			  if(ob[i].Id == suf) {
                          				  bookid1 = ob[i].BookId;
                          				continue;
                          			  }
                          			  else {
                          				  ob1[as] = ob[i];
                          				  as++;
                          			  }
                          		  }
                          		obj.close();
                    		  }catch(Exception e) {
                  				System.out.println(e);
                  			}
                    		
                    		File s = new File("Members.dat");
                      		FileOutputStream fa = new FileOutputStream(s);
                      		ObjectOutputStream ffd = new ObjectOutputStream(fa);
                      		File count = new File("Count1.dat");
                      		FileOutputStream  dfg = new FileOutputStream(count);
                            ObjectOutputStream objr1 = new ObjectOutputStream(dfg);
                            objr1.writeObject(c-1);
                            objr1.close();
                      	
                      		for(int i=0; i<c-1; i++) {
                      			ffd.writeObject(ob1[i]);
                      		}
                      		ffd.close();

                    		File faa = new File("BooksRecord.dat");
                        	FileInputStream ofa = new FileInputStream(faa);
                    		ObjectInputStream obja = new ObjectInputStream(ofa);
                    		File fad = new File("Counter.dat");
                    		FileInputStream of1a = new FileInputStream(fad);
                    		ObjectInputStream obj11 = new ObjectInputStream(of1a);
                    		int c2 = (int) obj11.readObject();
                    		LibraryManagement.Books ob2[] = new Books[c2];
                    		obj11.close();
                    			try {
                    				for(int i=0; i<c2; i++) {
                    					ob2[i] = (LibraryManagement.Books)obja.readObject();
                    					if(ob2[i].id == bookid1) {
                    						ob2[i].count++;
                    					}
                    				}
                    				obja.close();
                    			} catch(Exception e) {
                    				System.out.println(e);
                    			}
                    			File fq = new File("BooksRecord.dat");
                        		FileOutputStream fz = new FileOutputStream(fq);
                        		ObjectOutputStream fd = new ObjectOutputStream(fz);
                        		for(int i=0; i<c2; i++) {
                        			fd.writeObject(ob2[i]);
                        		}
                        		fd.close();
                        }
                        if(pop == 9) {
                        	
           		         System.out.println("press 1 to show notification");
           		         System.out.println("press 2 to clear notification area");
           		         int nh = Integer.parseInt(br.readLine());
           		         if(nh == 1) {
           		        	 try {
           		        		BufferedReader in1 = new BufferedReader(new FileReader("Notification.dat"));
                  		        String str1;
               		        	while ((str1 = in1.readLine()) != null) {
                   		            System.out.println(str1);
                   		         }
               		        	in1.close();
           		        	 }catch (Exception e) {
           		        		 System.out.println("No Notification");
           		        	 }
           		        	System.out.println();
           		         }
           		         if(nh == 2) {
           		         File fg = new File("Notification.dat");
           		         fg.delete();
           		         }
           		         
                        }
                        if(pop == 6) {
                        	File f = new File("Members.dat");
                        	FileInputStream of = new FileInputStream(f);
                    		ObjectInputStream obj = new ObjectInputStream(of);
                    		
                    		File f1 = new File("Count1.dat");
                    		FileInputStream of1 = new FileInputStream(f1);
                    		ObjectInputStream obj1 = new ObjectInputStream(of1);
                    		
                    		int c = (int) obj1.readObject();
                    		LibraryManagement.Member ob[] = new Member[c];
                    		obj1.close();
                    		
                    		int bookid1 = 0; 
                    		  try {
                    			  System.out.println("Enter the id of member you want to take back book");
                          		  int fna = Integer.parseInt(br.readLine());
                          		  for(int i=0; i<c; i++) {
                          			  ob[i] = (LibraryManagement.Member) obj.readObject();
                          			  if(ob[i].Id == fna) {
                          				  bookid1 = ob[i].BookId;
                          				  ob[i].BookId = 0;
                          				  ob[i].Date = "Nothing to show";
                          				  ob[i].SubDate = "Nothing to show";
                          				
                          			  }
                          			  
                          		  }
                          		obj.close();
                    		  }catch(Exception e) {
                  				System.out.println(e);
                  			}
                    		  File s = new File("Members.dat");
                        		FileOutputStream fa = new FileOutputStream(s);
                        		ObjectOutputStream ffd = new ObjectOutputStream(fa);

                          		for(int i=0; i<c; i++) {
                          			ffd.writeObject(ob[i]);
                          		}
                          		ffd.close();
                    		File faa = new File("BooksRecord.dat");
                          	FileInputStream ofa = new FileInputStream(faa);
                      		ObjectInputStream obja = new ObjectInputStream(ofa);
                      		File fad = new File("Counter.dat");
                      		FileInputStream of1a = new FileInputStream(fad);
                      		ObjectInputStream obj11 = new ObjectInputStream(of1a);
                      		int c2 = (int) obj11.readObject();
                      		LibraryManagement.Books ob2[] = new Books[c2];
                      		obj11.close();
                      			try {
                      				for(int i=0; i<c2; i++) {
                      					ob2[i] = (LibraryManagement.Books)obja.readObject();
                      					if(ob2[i].id == bookid1) {
                      						ob2[i].count++;
                      					}
                      				}
                      				obja.close();
                      			} catch(Exception e) {
                      				System.out.println(e);
                      			}
                      			File fq = new File("BooksRecord.dat");
                          		FileOutputStream fz = new FileOutputStream(fq);
                          		ObjectOutputStream fd = new ObjectOutputStream(fz);
                          		for(int i=0; i<c2; i++) {
                          			fd.writeObject(ob2[i]);
                          		}
                          		fd.close();
                    		
                        }
                        
                      }
                     while(pop!=0);
                }

                	else {
                		System.out.println("You have entered wrong Username & password");
                        System.out.println("        Sorry try again later");
                	}
                }
                if(entry1 == 2) {
                	System.out.println("Welcome you to Member area");
                	System.out.println("Enter your uniq id");
                	int memi = Integer.parseInt(br.readLine());
                	int pop;
                	
                	do {
                		System.out.println("press 1 for show your details");
                		System.out.println("press 2 for show books available on library");
                		System.out.println("press 3 for  give a request on issue or return book");
                		System.out.println("press 0 for exit");
                		pop = Integer.parseInt(br.readLine());
                		if(pop == 1) {
                			File f = new File("Members.dat");
                        	FileInputStream of = new FileInputStream(f);
                    		ObjectInputStream obj = new ObjectInputStream(of);
                    		
                    		File f1 = new File("Count1.dat");
                    		FileInputStream of1 = new FileInputStream(f1);
                    		ObjectInputStream obj1 = new ObjectInputStream(of1);
                    		
                    		int c = (int) obj1.readObject();
                    		LibraryManagement.Member ob[] = new Member[c];
                    		obj1.close();
                    		  try {
                          		  for(int i=0; i<c; i++) {
                          			  ob[i] = (LibraryManagement.Member) obj.readObject();
                          			  if(ob[i].Id == memi) {
                          				  ob[i].ShowMember();
                          			  }
                          			  obj.close();
                          		  }
                          		
                    		  }catch(Exception e) {
                  				System.out.println(e);
                  			}
                		}
                		if(pop == 2) {
                			File f = new File("BooksRecord.dat");
                        	FileInputStream of = new FileInputStream(f);
                    		ObjectInputStream obj = new ObjectInputStream(of);
                    		File f1 = new File("Counter.dat");
                    		FileInputStream of1 = new FileInputStream(f1);
                    		ObjectInputStream obj1 = new ObjectInputStream(of1);
                    		int c = (int) obj1.readObject();
                    		LibraryManagement.Books ob[] = new Books[c];
                    		obj1.close();
                    		
                    		System.out.println("Choose What you need to see");
                    		System.out.println("press 1 to see details of all books");
                    		System.out.println("press 2 to see details of customized by type books");
                    		int bc = Integer.parseInt(br.readLine());
                    		if(bc == 1) {
                    			try {
                    				for(int i=0; i<c; i++) {
                    					ob[i] = (LibraryManagement.Books)obj.readObject();
                    					ob[i].ShowBook();
                    				}
                    			}catch(Exception e) {
                    				System.out.println(e);
                    			}
                    			
                    		}
                    		if(bc == 2) {
                    			System.out.println("Enter type of books");
                    			String bt = br.readLine();
                    			try {
                    				int gh = 0;
                    				for(int i=0; i<c; i++) {
                    					ob[i] = (LibraryManagement.Books)obj.readObject();
                    					if(ob[i].type.equals(bt)) {
                    					ob[i].ShowBook();
                    					gh++;
                    					}
                    					if(gh==0) {
                    						System.out.println("Nothing this type books stored in library");
                    					}
                    				}
                    				obj.close();
                    			}
                    			catch(Exception e) {
                    				System.out.println(e);
                    			}
                    		}
                		}
                		if(pop == 3) {
                			 try {
                				 File fg = new File("Notification.dat");
                				 if(!fg.exists()) {
                					 fg.createNewFile();
                				 }
                				 FileWriter fileWritter = new FileWriter(fg.getName(),true);
                		         BufferedWriter bw = new BufferedWriter(fileWritter);
                		         System.out.println("press 1 if you want to request book");
                		         System.out.println("press 2 if tou want to return a book");
                		         System.out.println("press 3 if you write any personal request to admin");
                		         int b1 = Integer.parseInt(br.readLine());
                		         if(b1 == 1) {
                		        	 System.out.println("Enter book id you want to request");
                		        	 int ai = Integer.parseInt(br.readLine());
                    		         bw.write("My Member Id is "+memi+"  I Want to get a book which book id is "+ai+"\n");
                    		         
                		         }
                		         if(b1 == 2) {
                		        	 System.out.println("Enter book id you want to return");
                		        	 int ai = Integer.parseInt(br.readLine());
                		        	 bw.write("My Member Id is "+memi+"  I Want to return a book which book id is "+ai+"\n");
                		         }
                		         if(b1 == 3) {
                		        	 System.out.println("Enter your massage");
                		        	 String ai = br.readLine();
                		        	 bw.write("My Member Id is "+memi+"  I have a special massage to you\n"+ai);
                		         }
                		         bw.close();
                		         
                		      }
                		      
                		      catch (IOException e) {
                		         System.out.println("exception occoured"+ e);
                		      }
                			
                		}
                		
                	}while(pop!=0);
                	
                }
                    
             }
                
         }
