package longpipes;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * @authors up815386, up816571, up817807, up818360
 * 
 * This is the GUI  interface
 * It includes validation on inputs and error messages
 * It also adds pipes to an array an outputs the cost of all pipes
 */
public class PipeInterface extends javax.swing.JFrame {

    private final ArrayList<LongPipes> pipes; //used to store all the pipes created
    //some values intialsied for validation
    private double length = 0.5;
    private double outerDiameter = 1;
    private int quantity = 1;
    private int grade = 1;
    private int colour;
    private boolean reinforcement;
    private boolean insulation;
    private boolean resistance;
    private double totalOrderCost = 0; //used to display cost
    private int endOfArr = 0; //used to get one pipes cost
    private boolean checked = true; //validation variable

    /**
     * Creates new form MainFrame
     */
    public PipeInterface() {
        this.pipes = new ArrayList<>();
        initComponents();
        pipeGrade.setSelectedIndex(0); 
    }

    /**
     * After submit is click and all variables are validated the type of pipe is worked out
     * Then added to pipe array
     */
    public void addPipe() {
        if ((grade >= 1 && grade <= 3) && colour == 0) {
            pipes.add(new pipeType1(resistance, outerDiameter, 
                    length, quantity, grade, colour));
        } else if ((grade >= 2 && grade <= 4) && colour == 1) {
            pipes.add(new pipeType2(resistance, outerDiameter, 
                    length, quantity, grade, colour));
        } else if ((grade >= 2 && grade <= 5) && colour == 2 && insulation == false) {
            pipes.add(new pipeType3(resistance, outerDiameter, 
                    length, quantity, grade, colour));
        } else if ((grade >= 2 && grade <= 5) && colour == 2 && 
                insulation == true && reinforcement == false) {
            pipes.add(new pipeType4(resistance, outerDiameter, 
                    length, quantity, grade, colour, insulation));
        } else if ((grade >= 3 && grade <= 5) && colour == 2 && 
                insulation == true && reinforcement == true) {
            pipes.add(new pipeType5(resistance, outerDiameter, 
                    length, quantity, grade, colour, insulation, reinforcement));
        } else {
            checked = false;
            resetBoxes(); //If the inputs do not fit one of the pipes reset boxes to defualt
        }
    }
    
    /**
     * Resets all boxes on the GUI
     */
    public void resetBoxes() {
        pipeGrade.setSelectedIndex(0);
        pipeLength.setText("0.5");
        pipeDiameter.setText("1");
        pipeQuantity.setText("1");
        pipeColour.setSelectedIndex(0);
        chemResistance.setSelected(false);
        innerInsulation.setSelected(false);
        outerRein.setSelected(false);
    }

    /**
     * @param endOfArr used to output the cost of last pipe added
     */
    public void setTable(int endOfArr) {
        String tableInner;
        String tableOuter;
        String tableChemical;
        
        //output yes and no on the table instead of true and false
        if (insulation == true) {
            tableInner = "Yes";
        } else {
            tableInner = "No";
        }

        if (reinforcement == true) {
            tableOuter = "Yes";
        } else {
            tableOuter = "No";
        }

        if (resistance == true) {
            tableChemical = "Yes";
        } else {
            tableChemical = "No";
        }
        //add the pipes to the table rows
        DefaultTableModel model = (DefaultTableModel) pipeTable.getModel();
        model.addRow(new Object[]{length, outerDiameter, quantity, grade, 
            colour, tableInner, tableOuter, tableChemical,
            pipes.get(endOfArr).getTotalCost(), totalOrderCost});
    }
    
    /**
     * Used to set colour index t 0 and deselect the reinforcement and insulation check box
     * Used when the grade is changed for validation
     */
    public void disableButtons() {
        outerRein.setSelected(false);
        innerInsulation.setSelected(false);
        pipeColour.setSelectedIndex(0);
    }

    /**
     * @param value to be rounded
     * @return the rounded value to 2 decimals 
     */
    public double roundUp(double value) {
        return (double) Math.round(value * 100.0) / 100.0; 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pipeGrade = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pipeColour = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        chemResistance = new javax.swing.JCheckBox();
        innerInsulation = new javax.swing.JCheckBox();
        outerRein = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        pipeLength = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pipeDiameter = new javax.swing.JTextField();
        close = new javax.swing.JButton();
        resultOutput = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pipeQuantity = new javax.swing.JTextField();
        errorBox = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        singleOut = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pipeTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Long Pipe ");

        submit.setText("Calculate");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        jLabel1.setText("Choose Plastic Grade");

        pipeGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        pipeGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeGradeActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Avaliable Additional Options for Pipe"));

        jLabel5.setText("Inner Insulation ");

        jLabel6.setText("Chemical Resistance");

        jLabel7.setText("Outer Reinforcement");

        pipeColour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        pipeColour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeColourActionPerformed(evt);
            }
        });

        jLabel2.setText("Colour Print Number 0");

        chemResistance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chemResistanceActionPerformed(evt);
            }
        });

        innerInsulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                innerInsulationActionPerformed(evt);
            }
        });

        outerRein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outerReinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(pipeColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chemResistance)
                        .addGap(162, 162, 162)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(94, 94, 94))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(innerInsulation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(outerRein)
                        .addGap(137, 137, 137))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pipeColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(innerInsulation)
                                    .addComponent(outerRein))
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chemResistance)
                                .addGap(11, 11, 11))))))
        );

        jLabel9.setText("Length of Pipe (m)");

        pipeLength.setText("0.5");
        pipeLength.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pipeLengthFocusLost(evt);
            }
        });

        jLabel10.setText("Diameter of Pipe (in)");

        pipeDiameter.setText("1");
        pipeDiameter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pipeDiameterFocusLost(evt);
            }
        });

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        resultOutput.setEditable(false);
        resultOutput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Total cost");

        jLabel11.setText("Quantity of Pipes");

        pipeQuantity.setText("1");
        pipeQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pipeQuantityFocusLost(evt);
            }
        });

        errorBox.setForeground(new java.awt.Color(255, 0, 0));

        jLabel4.setText("Single item cost");

        singleOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pipe Length", "Pipe Diameter", "Quantity", "Plastic Grade", "Colour print", "Inner insulation", "Outer reinforcement", "Chemical Resistance", "Cost", "Total Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(pipeTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(pipeGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pipeLength))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pipeDiameter))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pipeQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(submit)
                                .addGap(464, 464, 464)
                                .addComponent(close))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(singleOut, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(resultOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(errorBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(155, 246, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pipeGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pipeLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pipeDiameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pipeQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(singleOut, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(resultOutput)))
                    .addComponent(errorBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(close))
                .addGap(18, 18, 18))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Long Pipes");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        /**
         * Try to add  pipe when the submit button is pressed 
         * If a pipe was added get the total and single cost and output to the GUI
         * Finally add it to the table
         */
        checked = true;
        addPipe();
        if (checked) {
            totalOrderCost = 0;
            pipes.forEach((pipe) -> {
                totalOrderCost += pipe.getTotalCost();
            });
            resultOutput.setText(String.valueOf(roundUp(totalOrderCost)));
            endOfArr = pipes.size() - 1;
            singleOut.setText(String.valueOf(pipes.get(endOfArr).getTotalCost()));

            setTable(endOfArr);
        }
    }//GEN-LAST:event_submitActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        //End the program on the exit button
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    private void pipeColourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeColourActionPerformed
        /**
         * set the value of colour with the current item 
         */
        
        String input;
        int converter; 
        input =  String.valueOf(pipeColour.getSelectedItem());
        converter = Integer.parseInt(input);
        colour = converter;
       
        //If colour is 0 or 1 disable insualtion and reinforcemnt
        if (converter >= 0 && converter <= 1) {
            innerInsulation.setEnabled(false);
            innerInsulation.setSelected(false);
            outerRein.setEnabled(false);
            outerRein.setSelected(false);
        } else if (converter == 2){
            //if colour is 2 set insulation to be enabled
            innerInsulation.setEnabled(true);
        }
    }//GEN-LAST:event_pipeColourActionPerformed

    private void chemResistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chemResistanceActionPerformed
        //Set value of chemical resistance
        resistance = chemResistance.isSelected();
    }//GEN-LAST:event_chemResistanceActionPerformed

    private void innerInsulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_innerInsulationActionPerformed
        /**
         * set the value of insulation, if its selected enable reinforcement
         * But disable the reinforcement if grade is 2 as reinforcement starts at grade 3
         */
        if (innerInsulation.isSelected()) {
            insulation = true;
            outerRein.setEnabled(true);
        } else {
            insulation = false;
            outerRein.setEnabled(false);
            outerRein.setSelected(false);
        }
        if (grade == 2) {
            outerRein.setEnabled(false);
            outerRein.setSelected(false);
        }
    }//GEN-LAST:event_innerInsulationActionPerformed

    private void outerReinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outerReinActionPerformed
        //Set value of reinforcement
        reinforcement = outerRein.isSelected();
    }//GEN-LAST:event_outerReinActionPerformed

    private void pipeGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeGradeActionPerformed
        /**
         * Set the value of grade
         * The colour option after a grade of 2 and above is selected
         * Change the values on the colour combo box depending on grade
         * Reset the resistance and insulation boxes to be unselected and sometimes disable them
         * Also resets colour to lowest value so it has a selected index that exists
         */
        
        int input;
        input = pipeGrade.getSelectedIndex() + 1;
        grade = input;

        pipeColour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"0", "1", "2"}));
        pipeColour.setEnabled(true);

        switch (input) {
            case 1:
                pipeColour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"0"}));
                colour = 0;
                pipeColour.setEnabled(false);
                innerInsulation.setEnabled(false);
                outerRein.setEnabled(false);
                disableButtons();
                break;
            case 2:
                disableButtons();
                colour = 0;
                pipeColour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"0","1", "2"}));
                break;
            case 3:
                disableButtons();
                colour = 0;
                pipeColour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"0","1", "2"}));
                break;
            case 4:
                disableButtons();
                colour = 1;
                pipeColour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2"}));
                break;
            case 5:
                outerRein.setSelected(false);
                outerRein.setEnabled(false);
                innerInsulation.setSelected(false);
                pipeColour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"2"}));
                pipeColour.setSelectedIndex(0);
                colour = 2;
                break;
            default:
                break;
        }
    }//GEN-LAST:event_pipeGradeActionPerformed

    private void pipeLengthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pipeLengthFocusLost
        /**
         * Sets the value of length if its valid 
         * If not reset to default min or max values 
         * If input is not a number reset to min value
         */   
        double input;
        try {
            input = Double.parseDouble(pipeLength.getText());
            if (input >= 0.5 && input <= 6) {
                length = input;
            } else if (input <  0.5) {
                pipeLength.setText("0.5");
                length = 0.5;
            } else if (input > 6) {
                pipeLength.setText("6");
                length = 6;
            }
        } catch (NumberFormatException e) {
            pipeLength.setText("0.5");
            length = 0.5;
        }
    }//GEN-LAST:event_pipeLengthFocusLost

    private void pipeDiameterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pipeDiameterFocusLost
        /**
         * Sets the value of outerDiameter if its valid 
         * If not reset to default min or max values 
         * If input is not a number reset to min value
         */
        double input;
        try {
            input = Double.parseDouble(pipeDiameter.getText());
            if (input >= 1 && input <= 20) {
                outerDiameter = input;
            } else if (input <  1) {
                pipeDiameter.setText("1");
                outerDiameter = 1;
            } else if (input > 20) {
                pipeDiameter.setText("20");
                outerDiameter = 20;
            }
        } catch (NumberFormatException e) {
            pipeDiameter.setText("1");
            outerDiameter = 1;
        }
    }//GEN-LAST:event_pipeDiameterFocusLost

    private void pipeQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pipeQuantityFocusLost
        /**
         * Sets the value of quantity if its valid 
         * If not reset to default min or max values 
         * If input is not a number reset to min value
         */
        
        int input;
        try {
            input = parseInt(pipeQuantity.getText());
            if (input >= 1 && input <= 20) {
                quantity = input;
            } else if (input <  1) {
                pipeQuantity.setText("1");
                quantity = 1;
                errorBox.setText("minimum quantity must be 1");
            } else if (input > 20) {
                pipeQuantity.setText("20");
                quantity = 20;
            }
        } catch (NumberFormatException e) {
            pipeQuantity.setText("1");
            quantity = 1;
        }
    }//GEN-LAST:event_pipeQuantityFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PipeInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PipeInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PipeInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PipeInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PipeInterface().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chemResistance;
    private javax.swing.JButton close;
    private javax.swing.JLabel errorBox;
    private javax.swing.JCheckBox innerInsulation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox outerRein;
    private javax.swing.JComboBox<String> pipeColour;
    private javax.swing.JTextField pipeDiameter;
    private javax.swing.JComboBox<String> pipeGrade;
    private javax.swing.JTextField pipeLength;
    private javax.swing.JTextField pipeQuantity;
    private javax.swing.JTable pipeTable;
    private javax.swing.JTextField resultOutput;
    private javax.swing.JLabel singleOut;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
