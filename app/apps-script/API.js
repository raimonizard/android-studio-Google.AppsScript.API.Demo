// Variables declarades dins de l'Apps Script a Configuración del proyecto / Propiedades de secuencia de comandos
const BASE_URL = PropertiesService.getScriptProperties().getProperty("BASE_URL");
const API_KEY = PropertiesService.getScriptProperties().getProperty("API_KEY");

function doGet(e) {

  const apiKey = (e.parameter.apiKey || "").trim();
  if (apiKey !== API_KEY) throw new Error("Unauthorized: API key incorrecta.");

  const sheet = SpreadsheetApp.getActiveSpreadsheet().getSheetByName("Full 1");
  const data = sheet.getDataRange().getValues();

  const headers = data[0];
  const jsonData = [];

  for (let i = 1; i < data.length; i++) {
    let rowData = {};
    for (let j = 0; j < headers.length; j++) {
      rowData[headers[j]] = data[i][j];
    }
    jsonData.push(rowData);
  }

  const response = {
    status: "ok",
    type: "arc",
    data: jsonData
  };

  return ContentService
    .createTextOutput(JSON.stringify(response))
    .setMimeType(ContentService.MimeType.JSON);
}

/*************************************************TESTING*******************************************************************************/
/**
 * Funció de test de la funció doGet
 */
function testGet() {
  const mockEventData = {
    parameter: {
      type: "arc"
    }
  };

  Logger.log(BASE_URL);
  Logger.log("Test: Obtenir DADES");
  Logger.log(doGet().getContent());
}