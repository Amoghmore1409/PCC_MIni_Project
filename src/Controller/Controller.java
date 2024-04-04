package Controller;

import Model.Utils.Model;
import View.View;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;


public class Controller {
    Model model;
    View view;

    public Controller(Model m, View v)
    {
        model = m;
        view = v;

        view.getMaf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });
        view.getMbf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });
        view.getMpf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        view.getFf().getManageActorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFf().setVisible(false);
                view.getMaf().setVisible(true);
            }
        });
        view.getFf().getManageMoviesBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFf().setVisible(false);
                view.getMbf().setVisible(true);
            }
        });
        view.getFf().getManageCastingBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFf().setVisible(false);
                view.getMpf().setVisible(true);
            }
        });

        model.getMs1().setLinesBeingDisplayed(15);
        view.centerInitialSetupActor(model.getMs1().getLinesBeingDisplayed(),model.getMs1().getHeaders().size());
        model.getMs1().setFirstLineToDisplay(0);
        view.centerUpdateActor(model.getMs1().getLines(model.getMs1().getFirstLineToDisplay(),model.getMs1().getLastLineToDisplay()),model.getMs1().getHeaders());

        view.getMaf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMs1().getFirstLineToDisplay();
                int current_last_line = model.getMs1().getLastLineToDisplay();
                int no_of_actors = model.getMs1().getTable().size();
                int no_of_display_lines = model.getMs1().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMs1().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMs1().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMs1().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_actors-1)
                {
                    model.getMs1().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_actors-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_actors - no_of_display_lines)
                    {
                        new_first_line = no_of_actors-no_of_display_lines;
                        model.getMs1().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMs1().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateActor(model.getMs1().getLines(model.getMs1().getFirstLineToDisplay(), model.getMs1().getLastLineToDisplay()), model.getMs1().getHeaders());
            }
        });

        view.getMaf().getIp().getAps().getAddActorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_id = view.getMaf().getIp().getAps().getTxt_id().getText();
                String txt_name = view.getMaf().getIp().getAps().getTxt_name().getText();
                String txt_genre = view.getMaf().getIp().getAps().getTxt_genre().getText();
                String txt_rating = view.getMaf().getIp().getAps().getTxt_rating().getText();
                String txt_language = view.getMaf().getIp().getAps().getTxt_language().getText();
                try {
                    model.getMs1().addNewActor(Integer.valueOf(txt_id),txt_name,txt_genre,txt_language,Integer.valueOf(txt_rating));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        view.getMaf().getIp().getEps().getGetActorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Actors Details Clicked");
                String txt_actor_idx= view.getMaf().getIp().getEps().getTxt_get_Actor_idx().getText();
                model.getMs1().readActorJsonFile("src/Model/Actors/MOCK_DATA (5).json");
                int actor_id = model.getMs1().getTable().get(Integer.valueOf(txt_actor_idx)).getActorID();
                String actor_name = model.getMs1().getTable().get(Integer.valueOf(txt_actor_idx)).getActorName();
                String actor_genre = model.getMs1().getTable().get(Integer.valueOf(txt_actor_idx)).getActorGenre();
                int actor_rating = model.getMs1().getTable().get(Integer.valueOf(txt_actor_idx)).getActorRating();
                String actor_language= model.getMs1().getTable().get(Integer.valueOf(txt_actor_idx)).getActorLanguage();
                view.getMaf().getIp().getEps().getTxt_actor_id().setText(String.valueOf(actor_id));
                view.getMaf().getIp().getEps().getTxt_actor_name().setText(actor_name);
                view.getMaf().getIp().getEps().getTxt_actor_genre().setText(actor_genre);
                view.getMaf().getIp().getEps().getTxt_actor_language().setText(actor_language);
                view.getMaf().getIp().getEps().getTxt_actor_rating().setText(String.valueOf(actor_rating));
            }
        });
        view.getMaf().getIp().getEps().getEditActorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Actors Button Clicked");
                String txt_actor_idx= view.getMaf().getIp().getEps().getTxt_get_Actor_idx().getText();
                String txt_actor_id = view.getMaf().getIp().getEps().getTxt_actor_id().getText();
                String txt_actor_name =view.getMaf().getIp().getEps().getTxt_actor_name().getText();
                String txt_actor_genre = view.getMaf().getIp().getEps().getTxt_actor_genre().getText();
                String txt_actor_rating = view.getMaf().getIp().getEps().getTxt_actor_rating().getText();
                String txt_actor_language=view.getMaf().getIp().getEps().getTxt_actor_language().getText();
                try {
                    model.getMs1().editActor(Integer.valueOf(txt_actor_idx),Integer.valueOf(txt_actor_id),txt_actor_name,txt_actor_genre,Integer.valueOf(txt_actor_rating),txt_actor_language);
                    view.centerUpdateActor(model.getMs1().getLines(model.getMs1().getFirstLineToDisplay(),model.getMs1().getLastLineToDisplay()),model.getMs1().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        view.getMaf().getIp().getDps().getDeleteActorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Actor Button Clicked");
                String txt_actor_idx = view.getMaf().getIp().getDps().getTxt_del_actor_id().getText();
                try {
                    int actorID = model.getMs1().deleteActor(Integer.valueOf(txt_actor_idx));
                    for(int i =0; i < model.getMs1().getTable().size(); i++)
                    {
                        if (actorID == model.getMs1().getTable().get(i).getActorID())
                        {
                            model.getMs1().deleteActor(i);
                        }
                    }view.centerUpdateActor(model.getMs1().getLines(model.getMs1().getFirstLineToDisplay(),model.getMs1().getLastLineToDisplay()),model.getMs1().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        model.getMs2().setLinesBeingDisplayed(15);
        view.centerInitialSetupMovie(model.getMs2().getLinesBeingDisplayed(),model.getMs2().getHeaders().size());
        model.getMs2().setFirstLineToDisplay(0);
        view.centerUpdateMovie(model.getMs2().getLines(model.getMs2().getFirstLineToDisplay(),model.getMs2().getLastLineToDisplay()),model.getMs2().getHeaders());

        view.getMbf().getBipp().getBp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMs2().getFirstLineToDisplay();
                int current_last_line = model.getMs2().getLastLineToDisplay();
                int no_of_movies = model.getMs2().getTable().size();
                int no_of_display_lines = model.getMs2().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMs2().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMs2().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMs2().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_movies-1)
                {
                    model.getMs2().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_movies-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_movies - no_of_display_lines)
                    {
                        new_first_line = no_of_movies-no_of_display_lines;
                        model.getMs2().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMs2().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateMovie(model.getMs2().getLines(model.getMs2().getFirstLineToDisplay(), model.getMs2().getLastLineToDisplay()), model.getMs2().getHeaders());
            }
        });

        view.getMbf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });
        view.getMbf().getBipp().getBps().getAddMovieBtnBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_bid = view.getMbf().getBipp().getBps().getTxt_bid().getText();
                String txt_name = view.getMbf().getBipp().getBps().getTxt_name().getText();
                String txt_genre = view.getMbf().getBipp().getBps().getTxt_genre().getText();
                String txt_price = view.getMbf().getBipp().getBps().getTxt_price().getText();
                String txt_language =view.getMbf().getBipp().getBps().getTxt_language().getText();
                String txt_sales= view.getMbf().getBipp().getBps().getTxt_sales().getText();

                try {
                    model.getMs2().addNewMovie(Integer.valueOf(txt_bid),txt_name,txt_genre,txt_language,Integer.valueOf(txt_price),Integer.parseInt(txt_sales));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        view.getMbf().getBipp().getEmp().getGetMovieBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Movie Details Clicked");
                String txt_movie_idx= view.getMbf().getBipp().getEmp().getTxt_get_Movie_idx().getText();
                model.getMs2().readMoviesJsonFile("src/Model/Movies/MOCK_DATA (4).json");
                int movie_id = model.getMs2().getTable().get(Integer.valueOf(txt_movie_idx)).getMovieID();
                String movie_name = model.getMs2().getTable().get(Integer.valueOf(txt_movie_idx)).getMovieName();
                String movie_genre = model.getMs2().getTable().get(Integer.valueOf(txt_movie_idx)).getGenre();
                int movie_price = model.getMs2().getTable().get(Integer.valueOf(txt_movie_idx)).getPrice();
                int movie_sales = model.getMs2().getTable().get(Integer.valueOf(txt_movie_idx)).getCopiesSold();
                String movie_language= model.getMs2().getTable().get(Integer.valueOf(txt_movie_idx)).getLanguage();
                view.getMbf().getBipp().getEmp().getTxt_Movie_id().setText(String.valueOf(movie_id));
                view.getMbf().getBipp().getEmp().getTxt_Movie_name().setText(movie_name);
                view.getMbf().getBipp().getEmp().getTxt_Movie_genre().setText(movie_genre);
                view.getMbf().getBipp().getEmp().getTxt_Movie_language().setText(movie_language);
                view.getMbf().getBipp().getEmp().getTxt_Movie_price().setText(String.valueOf(movie_price));
                view.getMbf().getBipp().getEmp().getTxt_Movie_copiesSold().setText(String.valueOf(movie_sales));
            }
        });
        view.getMbf().getBipp().getEmp().getEditMovieBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Movies Button Clicked");
                String txt_Movie_idx= view.getMbf().getBipp().getEmp().getTxt_get_Movie_idx().getText();
                String txt_Movie_id = view.getMbf().getBipp().getEmp().getTxt_Movie_id().getText();
                String txt_Movie_name =view.getMbf().getBipp().getEmp().getTxt_Movie_name().getText();
                String txt_Movie_genre = view.getMbf().getBipp().getEmp().getTxt_Movie_genre().getText();
                String txt_Movie_sales = view.getMbf().getBipp().getEmp().getTxt_Movie_copiesSold().getText();
                String txt_Movie_language=view.getMbf().getBipp().getEmp().getTxt_Movie_language().getText();
                String txt_Movie_price = view.getMbf().getBipp().getEmp().getTxt_Movie_price().getText();
                try {
                    model.getMs2().editMovie(Integer.valueOf(txt_Movie_idx),Integer.valueOf(txt_Movie_id),txt_Movie_name,txt_Movie_genre , txt_Movie_language,Integer.valueOf(txt_Movie_price),Integer.valueOf(txt_Movie_sales));
                    view.centerUpdateMovie(model.getMs2().getLines(model.getMs2().getFirstLineToDisplay(),model.getMs2().getLastLineToDisplay()),model.getMs2().getHeaders());

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        view.getMbf().getBipp().getDmp().getDeleteMovieBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Movie Button Clicked");
                String txt_movie_idx = view.getMbf().getBipp().getDmp().getTxt_del_movie_id().getText();
                try {
                    int movieID = model.getMs2().deleteMovie(Integer.valueOf(txt_movie_idx));
                    for(int i =0; i < model.getMs2().getTable().size(); i++)
                    {
                        if (movieID == model.getMs2().getTable().get(i).getMovieID())

                        {
                            model.getMs2().deleteMovie(i);
                        }
                    } view.centerUpdateMovie(model.getMs2().getLines(model.getMs2().getFirstLineToDisplay(),model.getMs2().getLastLineToDisplay()),model.getMs2().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        model.getMs3().setLinesBeingDisplayed(15);
        view.centerInitialSetupCast(model.getMs3().getLinesBeingDisplayed(),model.getMs3().getHeaders().size());
        model.getMs3().setFirstLineToDisplay(0);
        view.centerUpdateCast(model.getMs3().getLines(model.getMs3().getFirstLineToDisplay(),model.getMs3().getLastLineToDisplay()),model.getMs3().getHeaders());

        view.getMpf().getPipp().getPp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMs3().getFirstLineToDisplay();
                int current_last_line = model.getMs3().getLastLineToDisplay();
                int no_of_cast = model.getMs3().getTable().size();
                int no_of_display_lines = model.getMs3().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMs3().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMs3().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMs3().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_cast-1)
                {
                    model.getMs3().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_cast-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_cast - no_of_display_lines)
                    {
                        new_first_line = no_of_cast-no_of_display_lines;
                        model.getMs3().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMs3().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateCast(model.getMs3().getLines(model.getMs3().getFirstLineToDisplay(), model.getMs3().getLastLineToDisplay()), model.getMs3().getHeaders());
            }
        });


      view.getMpf().getPipp().getPps().getAddDirectorBtn().addActionListener(new ActionListener() {
           @Override
         public void actionPerformed(ActionEvent e) {
             String movieID = view.getMpf().getPipp().getPps().getTxt_B().getText();
             String actorID = view.getMpf().getPipp().getPps().getTxt_A().getText();
             String txt_castingDate = view.getMpf().getPipp().getPps().getTxt_castingDate().getText();
             String txt_director = view.getMpf().getPipp().getPps().getTxt_director().getText();
             try {
                 model.getMs3().addNewCast(Integer.valueOf(actorID),Integer.valueOf(movieID),txt_castingDate,txt_director);
             } catch (IOException ex) {
                 throw new RuntimeException(ex);
               }
       }
       });
        view.getMpf().getPipp().getEcp().getGetCastBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Casting Details Clicked");
                String txt_cast_idx = view.getMpf().getPipp().getEcp().getTxt_get_Cast_idx().getText();
                model.getMs3().readCastingJsonFile("src/Model/Casting/MOCK_DATA (3).json");
                int actorID = model.getMs3().getTable().get(Integer.valueOf(txt_cast_idx)).getA_temp().getActorID();
                int movieID = model.getMs3().getTable().get(Integer.valueOf(txt_cast_idx)).getB_temp().getMovieID();
                String casting_date = model.getMs3().getTable().get(Integer.valueOf(txt_cast_idx)).getCastingDate();
                String director = model.getMs3().getTable().get(Integer.valueOf(txt_cast_idx)).getDirector();
                view.getMpf().getPipp().getEcp().getTxt_actor_id().setText(String.valueOf(actorID));
                view.getMpf().getPipp().getEcp().getTxt_movie_id().setText(String.valueOf(movieID));
                view.getMpf().getPipp().getEcp().getTxt_casting_date().setText(casting_date);
                view.getMpf().getPipp().getEcp().getTxt_director().setText(director);
            }
        });

        view.getMpf().getPipp().getEcp().getEditCastBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Casting Button Clicked");
                String txt_cast_idx = view.getMpf().getPipp().getEcp().getTxt_get_Cast_idx().getText();
                String txt_actor_idx = view.getMpf().getPipp().getEcp().getTxt_actor_id().getText();
                String txt_movie_idx = view.getMpf().getPipp().getEcp().getTxt_movie_id().getText();
                String txt_casting_date = view.getMpf().getPipp().getEcp().getTxt_casting_date().getText();
                String txt_director= view.getMpf().getPipp().getEcp().getTxt_director().getText();
                try {
                    model.getMs3().editCast(Integer.valueOf(txt_cast_idx),Integer.valueOf(txt_actor_idx),Integer.valueOf(txt_movie_idx),txt_casting_date,txt_director);
                    view.centerUpdateCast(model.getMs3().getLines(model.getMs3().getFirstLineToDisplay(),model.getMs3().getLastLineToDisplay()),model.getMs3().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMpf().getPipp().getDcp().getDeleteCastBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Casting Button Clicked");
                String txt_cast_idx = view.getMpf().getPipp().getDcp().getTxt_del_Cast_idx().getText();
                try {
                    model.getMs3().deleteCast(Integer.valueOf(txt_cast_idx));
                    view.centerUpdateCast(model.getMs3().getLines(model.getMs3().getFirstLineToDisplay(),model.getMs3().getLastLineToDisplay()),model.getMs3().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }

}
