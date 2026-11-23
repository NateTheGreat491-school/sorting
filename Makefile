# File:    Makefile
# Devs:    Nathan W. Barros
# Origin:  2026-11-23
# Edited:  2026-11-23

.PHONY: all jar run rebuild clean

JAVAC	:= javac
JAVA	:= java
MAKE	:= make
JAR		:= jar
JFLAGS	:= -encoding UTF-8

SRC_DIR	:= src
BLD_DIR	:= build
CLS_DIR	:= $(BLD_DIR)/class

MAIN_CLASS	:= $(BLD_DIR)/main.Main
JAR_FILE	:= $(BLD_DIR)/sorting.jar
SRC_FILES	:= $(wildcard $(SRC_DIR)/*/*.java)

RUN_AS ?= class

all: $(CLS_DIR):
	$(JAVAC) $(JFLAGS) -d $(CLS_DIR) -sourcepath $(SRC_DIR) $(SRC)

$(CLS_DIR):
	mkdir -p $(CLS_DIR)

jar: $(JAR_FILE)

$(JAR_FILE): all
	$(JAR) cfe $(JAR_FILE) $(MAIN) -C $(CLS_DIR)

run: all
ifeq ($(RUN_AS),jar)
	$(MAKE) jar
	$(JAVA) -jar $(JAR_FILE)
else
	$(JAVA) -cp $(CLS_DIR) $(MAIN)
endif

rebuild: clean all

clean:
	rm -rf $(BLD_DIR)
