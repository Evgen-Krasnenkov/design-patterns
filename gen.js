const fs = require('fs');
const path = require('path');

function generateFolderReadmes(rootDir) {
    let folderReadmes = '';

function traverseFolders(currentDir) {
    const files = fs.readdirSync(currentDir, { withFileTypes: true });

for (const file of files) {
    const filePath = path.join(currentDir, file.name);

if (file.name.toLowerCase() === 'readme.md') {
    const folderPath = path.relative(rootDir, currentDir);
const readmePath = path.relative(rootDir, filePath);
const readmeLink = `[${folderPath}](${readmePath})`;
folderReadmes += `- ${readmeLink}\n`;
}

if (file.isDirectory()) {
traverseFolders(filePath);
}
}
}

traverseFolders(rootDir);
return folderReadmes;
}

// Set the root directory of your project
const rootDirectory = '.'; // Replace this with your actual root directory

// Read the template file
const readmeTemplate = fs.readFileSync('readme-template.md', 'utf8');

// Generate the folder READMEs content
const folderReadmesContent = generateFolderReadmes(rootDirectory);

// Replace the placeholders in the template with actual content
const readmeContent = readmeTemplate.replace('<!-- FOLDER_READMES -->', folderReadmesContent);

// Write the final README file
fs.writeFileSync('readme.md', readmeContent);
